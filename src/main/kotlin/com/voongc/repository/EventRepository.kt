package com.voongc.repository

import com.google.gson.GsonBuilder
import com.mongodb.client.model.Filters.eq
import org.litote.kmongo.*
import com.voongc.data.*

object EventRepository {
    val gson = GsonBuilder().serializeNulls().create()


    val client = KMongo.createClient() //get com.mongodb.MongoClient new instance
    val db = client.getDatabase("feedme") //normal java driver usage


    //not currently working, update data model to show embedded
    fun updateMarket(eventId:String,market: EMarket) {
        val col = db.getCollection<EEvent>("catalogue") //KMongo extension method

        //fetch the event on which the market belongs
        val event = col.findOne(EEvent::id eq eventId)

        if (event == null) {
            println("Couldn't find event with id: $eventId")
            return
        }

        println("Event fetched $event")

        //add the market
        if (event.markets.count { it.id == market.id } > 1) {
            //replace with this market
            event.markets.map {
                if (it.id == market.id) {
                    event.markets.remove(it)
                }
            }
        }
        event.markets.add(market)

        println("Updated market $event")

        //save into collection
        val result = col.replaceOne(EEvent::id eq eventId, event, upsert())
        println(result)
    }

    fun updateOutcome(marketId:String,outcome: EOutcome){
        val col = db.getCollection<EEvent>("catalogue") //KMongo extension method
        val filter = eq("markets.id",marketId)
        val event = col.findOne(filter)

        if (event == null) {
            println("Couldn't find event from market with marketId: $marketId")
            return
        }
        println("Event fetched $event from outcome with marketId: $marketId")

        val market = event.markets.find{it.id==marketId}

        if (market==null) {
            println("Couldn't find market with marketId: $marketId")
            return
        }

        if (market.outcomes.count{it.id == outcome.id} > 1){
            market.outcomes.map{
                if (it.id==outcome.id){
                    market.outcomes.remove(it)
                }
            }
        }

        market.outcomes.add(outcome)
        println("Updated outcome $event")

        //save back into the collection
        val result = col.replaceOne(EEvent::id eq event.id,event, upsert())

        println(result)
    }

    fun updateEvent(event: EEvent){
        //fetch event
        val col = db.getCollection<EEvent>("catalogue") //KMongo extension method
        println("Updated event $event")

        val result = col.replaceOne(EEvent::id eq event.id,event,upsert())
        println(result)

    }

}