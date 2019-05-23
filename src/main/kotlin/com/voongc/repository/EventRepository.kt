package com.voongc.repository

import com.google.gson.GsonBuilder
import com.mongodb.MongoClient
import com.mongodb.client.model.Filters.eq
import com.mongodb.client.model.UpdateOptions
import com.voongc.data.Event
import com.voongc.data.Market
import com.voongc.data.Outcome
import org.bson.BsonDocument

object EventRepository {
    val mongoClient = MongoClient("localhost")
    val db = mongoClient.getDatabase("feedme")
    val gson = GsonBuilder().serializeNulls().create()
    val options = UpdateOptions().upsert(true)

    fun writeToRepository(jsonString: String){
        val collection = db.getCollection("catalogue", BsonDocument::class.java)
        collection.insertOne(BsonDocument.parse(jsonString))
    }

    //not currently working, update data model to show embedded
    fun updateMarket(market: Market){
        //fetch the event on which the market belongs
        //fetch the market
        //update the market
        //save into collection

        val collection =  db.getCollection("catalogue", BsonDocument::class.java)
        val filter = eq("id",market.eventId)

        val result=collection.replaceOne(filter,BsonDocument.parse(gson.toJson(market)),options)
        println(result)
    }

    fun updateOutcome(outcome: Outcome){}

    fun updateEvent(event: Event){
        //fetch event
        val collection =  db.getCollection("catalogue", BsonDocument::class.java)
        val filter = eq("id",event.id)

        val result=collection.replaceOne(filter,BsonDocument.parse(gson.toJson(event)),options)
        println(result)
    }

}