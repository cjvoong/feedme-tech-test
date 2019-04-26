package com.voongc

import com.voongc.client.FeedMeClient

fun main() {
    val client = FeedMeClient("localhost",8282)
    try {
        client.listen()
    } finally {
        client.clientSocket.close()
    }
}
