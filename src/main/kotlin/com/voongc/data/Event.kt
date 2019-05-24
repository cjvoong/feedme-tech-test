package com.voongc.data

data class Event(val id:String,val category:String,val subCategory:String,val name:String,val startTime:Long, val displayed:Boolean, val suspended:Boolean)

data class Market(val eventId: String,val id:String,val name:String,val displayed:Boolean,val suspended: Boolean)

data class Outcome(val marketId: String,val id:String,val name:String,val price:String,val displayed:Boolean,val suspended: Boolean)

data class EEvent(val id:String,val category:String,val subCategory:String,val name:String,val startTime:Long, val displayed:Boolean, val suspended:Boolean, val markets:MutableList<EMarket>)

data class EMarket(val id:String,val name:String,val displayed:Boolean,val suspended: Boolean, val outcomes:MutableList<EOutcome>)

data class EOutcome(val id:String,val name:String,val price:String,val displayed:Boolean,val suspended: Boolean)