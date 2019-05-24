package com.voongc.data

import com.voongc.transformers.JsonTransform
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TransformerTest{
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
        val outcomeString = """|3048|update|outcome|1558427979269|b839be63-5e4e-44d4-98e4-8660eedf0bcc|49add731-8e63-4307-8d44-d916b9108c0d|\|MK Dons\| 0-3|1/500|1|0|"""
        val outcome = FeedMessage.fromString(outcomeString)
        val actual = transform.fromOutcomeToJson(outcome)
        val expected = Outcome("49add731-8e63-4307-8d44-d916b9108c0d","\\|MK Dons\\| 0-3","1/500",true,false)
        assertEquals(expected,actual)
    }

    @Test
    fun testMarketMessage(){
        val marketString = """|3015|update|market|1558427978201|f304489c-f75b-496f-ade1-4c87d46852eb|b6e00f34-efec-49ee-a618-9d3c6e982af5|Goal Handicap (-1)|1|0|"""
        val market=FeedMessage.fromString(marketString)
        val actual = transform.fromMarketToJson(market)
        val expected = Market("b6e00f34-efec-49ee-a618-9d3c6e982af5","Goal Handicap (-1)",true,false)
        assertEquals(expected,actual)
    }

}