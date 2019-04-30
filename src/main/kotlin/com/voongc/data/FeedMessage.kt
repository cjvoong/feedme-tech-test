package com.voongc.data

/*
|2054|create|event|1497359166352|ee4d2439-e1c5-4cb7-98ad-9879b2fd84c2|Football|Sky Bet League Two|\|Accrington\| vs \|Cambridge\||1497359216693|0|1|
The beginning of each packet contains some header values. The header is a fix number of values for all packets. The values in the header are as follows:
msgId - This is an incremental integer unique to each packet
operation - This is a string value that will be either create or update
type - This is a string value that denotes the packet type, which will be either event, market or outcome
timestamp - This is an integer value of the clock time when the packet was sent (in milliseconds)
 */

data class FeedMessage (
    val msgId:String,
    val operation:String,
    val type:String,
    val timestamp:Long,
    val data:String
) {
    companion object {
        fun fromString(feedString:String):FeedMessage{
            val feedList = feedString.replace("\\","").split("|")
            val data = feedList.takeLast(feedList.size-5)

            println(feedList)
            println(data)
            return FeedMessage(feedList[1],feedList[2],feedList[3],feedList[4].toLong(),data.joinToString{"|"})
        }
    }
}