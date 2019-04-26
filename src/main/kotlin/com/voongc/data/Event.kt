package com.voongc.data

data class Event(
    val eventId:String,
    val category:String,
    val subCategory:String,
    val name:String,
    val startTime:Int,
    val displayed:Boolean,
    val suspended:Boolean
)

data class Market(
    val eventId: String,
    val marketId:String,
    val name:String,
    val displayed:Boolean,
    val suspended: Boolean
)

data class Outcome(
    val marketId: String,
    val outcomeId:String,
    val name:String,
    val price:String,
    val displayed:Boolean,
    val suspended: Boolean
)