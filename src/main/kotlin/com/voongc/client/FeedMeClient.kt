package com.voongc.client

import com.google.gson.GsonBuilder
import com.voongc.data.FeedMessage
import com.voongc.data.Type
import com.voongc.transformers.JsonTransform
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.Socket

class FeedMeClient (val host:String,val port:Int) : TcpClient {
    val clientSocket = Socket(host,port)
    val reader = BufferedReader(InputStreamReader(clientSocket.getInputStream()))
    val transform = JsonTransform()
    val gson = GsonBuilder().setPrettyPrinting().serializeNulls().create()


    fun read() {

        while (true){
            //read each line
            val line = reader.readLine()

            if (line==null)
                break

            println("raw message: $line")

            //deserialize as messageObject
            var message = FeedMessage.fromString(line)

            //transform to object
            val dataObject = when (message.type) {
                Type.event -> transform.fromEventToJson(message)
                Type.market -> transform.fromMarketToJson(message)
                Type.outcome -> transform.fromOutcomeToJson(message)
            }

            println("data: $dataObject")

            //serialize it as a json string
            val jsonString = gson.toJson(dataObject)

            //print it
            println("json: $jsonString")
        }
    }
}