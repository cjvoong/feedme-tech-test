package com.voongc.data

import com.voongc.transformers.JsonTransform
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FeedMessageTest{
    val transform = JsonTransform()

    @Test
    fun testEventMessage(){
        val eventString = """|34508|create|event|1558365940461|69c98eba-cc05-4fcf-b147-56945df0bdeb|Tennis|Wimbledon|\|Roger Federer\| vs \|Andy Murray\||1558365937576|0|1|""""
        val event  = FeedMessage.fromString(eventString)
        val actual = transform.fromEventToJson(event)
        val expected = Event("69c98eba-cc05-4fcf-b147-56945df0bdeb","Tennis","Wimbledon","\\|Roger Federer\\| vs \\|Andy Murray\\|",1558365937576,false,true)
        assertEquals(expected,actual)
    }

    @Test
    fun testOutcomeMessage(){
        val outcomeString = """"""
    }

    @Test
    fun testMarketMessage(){
        val marketString = """"""
    }

}