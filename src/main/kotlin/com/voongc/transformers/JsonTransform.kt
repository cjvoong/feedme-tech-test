package com.voongc.transformers

import com.voongc.data.Event
import com.voongc.data.FeedMessage
import com.voongc.data.Market
import com.voongc.data.Outcome

class JsonTransform {

    fun fromEventToJson(message:FeedMessage): Event {
        val data = message.data
        return Event(data[0],data[1],data[2],data[3],data[4].toLong(),convertBoolean(data[5]),convertBoolean(data[6]))
    }

    fun fromMarketToJson(message:FeedMessage): Market {
        val data = message.data
        return Market(data[0],data[1],data[2],convertBoolean(data[3]),convertBoolean(data[4]))
    }

    fun fromOutcomeToJson(message:FeedMessage): Outcome {
        val data = message.data
        return Outcome(data[0],data[1],data[2],data[3],convertBoolean(data[4]),convertBoolean(data[4]))
    }

    private fun convertBoolean(bit:String) =
        when (bit) {
            "0" -> false
            "1" -> true
            else -> false}
}

