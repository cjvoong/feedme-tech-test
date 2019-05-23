package com.voongc.data

open class Catalogue

data class Event(val id:String,val category:String,val subCategory:String,val name:String,val startTime:Long, val displayed:Boolean, val suspended:Boolean): Catalogue()

data class Market(val eventId: String,val id:String,val name:String,val displayed:Boolean,val suspended: Boolean) : Catalogue ()

data class Outcome(val marketId: String,val id:String,val name:String,val price:String,val displayed:Boolean,val suspended: Boolean) : Catalogue()

data class EEvent(val id:String,val category:String,val subCategory:String,val name:String,val startTime:Long, val displayed:Boolean, val suspended:Boolean)

data class EMarket(val event: EEvent,val id:String,val name:String,val displayed:Boolean,val suspended: Boolean)

data class EOutcome(val market: EMarket,val id:String,val name:String,val price:String,val displayed:Boolean,val suspended: Boolean)