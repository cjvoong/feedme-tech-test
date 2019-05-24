package com.voongc.transformers

import com.voongc.data.*
import java.lang.IllegalArgumentException

class JsonTransform {

    fun fromEventToJson(message:FeedMessage): EEvent {
        val data = message.data
        return EEvent(data[0],data[1],data[2],data[3],data[4].toLong(),convertBoolean(data[5]),convertBoolean(data[6]),
            mutableListOf<EMarket>())
    }

    fun fromMarketToJson(message:FeedMessage): EMarket {
        val data = message.data
        return EMarket(data[1],data[2],convertBoolean(data[3]),convertBoolean(data[4]), mutableListOf<EOutcome>())
    }

    fun fromOutcomeToJson(message:FeedMessage): EOutcome {
        val data = message.data
        return EOutcome(data[1],data[2],data[3],convertBoolean(data[4]),convertBoolean(data[5]))
    }

    private fun convertBoolean(bit:String) =
        when (bit) {
            "0" -> false
            "1" -> true
            else -> throw IllegalArgumentException("Couldn't convert $bit to Boolean")
        }
}

