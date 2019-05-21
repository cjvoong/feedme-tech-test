package com.voongc.repository

import com.mongodb.MongoClient
import org.bson.BsonDocument

object EventRepository {
    val mongoClient = MongoClient("localhost")
    val db = mongoClient.getDatabase("feedme")

    fun writeToRepository(jsonString: String){
        val collection = db.getCollection("catalogue", BsonDocument::class.java)
        collection.insertOne(BsonDocument.parse(jsonString))
    }
}