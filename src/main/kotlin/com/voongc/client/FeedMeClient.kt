package com.voongc.client

import com.voongc.data.FeedMessage
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.Socket

class FeedMeClient (val host:String,val port:Int) : TcpClient {
    val clientSocket = Socket(host,port)
    val reader = BufferedReader(InputStreamReader(clientSocket.getInputStream()))

    fun read(): FeedMessage {
        var line:String
        do {
            line = reader.readLine()

            println(line)

            val message = FeedMessage.fromString(line)

            println(message)

            return message
        } while (line != null)
    }
}