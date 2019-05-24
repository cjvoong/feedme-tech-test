package com.voongc.data

data class Event(val id:String, val category:String, val subCategory:String, val name:String, val startTime:Long, val displayed:Boolean, val suspended:Boolean, val markets:MutableList<Market> = mutableListOf())

data class Market(val id:String, val name:String, val displayed:Boolean, val suspended: Boolean, val outcomes:MutableList<Outcome> = mutableListOf())

data class Outcome(val id:String, val name:String, val price:String, val displayed:Boolean, val suspended: Boolean)