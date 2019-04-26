package com.voongc.client

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.Socket

class FeedMeClient (val host:String,val port:Int) : TcpClient {

    val clientSocket = Socket(host,port)

    val reader = BufferedReader(InputStreamReader(clientSocket.getInputStream()))

    fun listen(){
        var line:String
        do {
            line = reader.readLine()
            println(line)
        } while (line != null)
    }
}