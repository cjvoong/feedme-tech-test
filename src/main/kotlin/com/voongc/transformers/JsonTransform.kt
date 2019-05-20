package com.voongc.transformers

import com.voongc.data.Event
import com.voongc.data.FeedMessage
import com.voongc.data.Market
import com.voongc.data.Outcome

class JsonTransform {

    fun fromEventToJson(message:FeedMessage): Event {
        val data = message.data
        return Event(data[0],data[1],data[2],data[3],data[4].toInt(),data[5].toBoolean(),data[6].toBoolean())
    }

    fun fromMarketToJson(message:FeedMessage): Market {
        val data = message.data
        return Market(data[0],data[1],data[2],data[3].toBoolean(),data[4].toBoolean())
    }

    fun fromOutcomeToJson(message:FeedMessage): Outcome {
        val data = message.data
        return Outcome(data[0],data[1],data[2],data[3],data[4].toBoolean(),data[4].toBoolean())
    }

}