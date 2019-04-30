package com.voongc.data

open class Catalogue

data class Event(val id:String,val category:String,val subCategory:String,val name:String,val startTime:Int, val displayed:Boolean, val suspended:Boolean): Catalogue()

data class Market(val eventId: String,val id:String,val name:String,val displayed:Boolean,val suspended: Boolean) : Catalogue ()

data class Outcome(val marketId: String,val id:String,val name:String,val price:Double,val displayed:Boolean,val suspended: Boolean) : Catalogue()