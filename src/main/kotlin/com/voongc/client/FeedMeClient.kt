package com.voongc.client

import com.google.gson.GsonBuilder
import com.voongc.data.*
import com.voongc.service.CatalogueService
import com.voongc.transformers.JsonTransform
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.Socket

class FeedMeClient (val host:String,val port:Int) : TcpClient {
    val clientSocket = Socket(host,port)
    val reader = BufferedReader(InputStreamReader(clientSocket.getInputStream()))
    val transform = JsonTransform()
    val gson = GsonBuilder().serializeNulls().create()
    val service = CatalogueService()


    fun read() {

        while (true){
            //read each line
            val line = reader.readLine() ?: break

            println("raw message: $line")

            //deserialize as messageObject
            var message = FeedMessage.fromString(line)

            println("message $message")

            //transform to object
            val dataObject = when (message.type) {
                Type.event -> transform.fromEventToJson(message)
                Type.market -> transform.fromMarketToJson(message)
                Type.outcome -> transform.fromOutcomeToJson(message)
            }

            println("data: $dataObject")

            when (dataObject){
                is Event -> service.updateEvent(dataObject)
                is Market -> service.updateMarket(message.data[0],dataObject)
                is Outcome -> service.updateOutcome(message.data[0],dataObject)
                else -> println("Not writing")
            }

            //serialize it as a json string
            val jsonString = gson.toJson(dataObject)

            //print it
            println("json: $jsonString")

        }
    }
}