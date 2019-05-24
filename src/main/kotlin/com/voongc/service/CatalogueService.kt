package com.voongc.service

import com.voongc.data.Event
import com.voongc.data.Market
import com.voongc.data.Outcome
import com.voongc.repository.CatalogueRepository

class CatalogueService{

    val repo = CatalogueRepository()

    fun updateEvent(event: Event){
        repo.updateEvent(event)
    }

    fun updateMarket(eventId:String,market: Market) {
        repo.updateMarket(eventId,market)
    }

    fun updateOutcome(marketId:String,outcome: Outcome){
        repo.updateOutcome(marketId,outcome)
    }
}