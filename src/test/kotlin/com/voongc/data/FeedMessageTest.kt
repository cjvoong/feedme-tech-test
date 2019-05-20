package com.voongc.data

import org.junit.jupiter.api.Test

class FeedMessageTest{
    @Test
    fun testEventMessage(){
        val eventString = """|34508|create|event|1558365940461|69c98eba-cc05-4fcf-b147-56945df0bdeb|Tennis|Wimbledon|\|Roger Federer\| vs \|Andy Murray\||1558365937576|0|1|""""
        val actual = FeedMessage.fromString(eventString)
        assert(true)
    }

}