package com.voongc.repository

import com.voongc.data.*

interface CatalogueRepository {
    //not currently working, update data model to show embedded
    fun updateMarket(eventId:String,market: Market)

    fun updateOutcome(marketId:String,outcome: Outcome)

    fun updateEvent(event: Event)

}