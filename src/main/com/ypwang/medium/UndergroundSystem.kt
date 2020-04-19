package com.ypwang.medium

class UndergroundSystem() {
    private class Count {
        var sum = 0
        var c = 0
    }

    private val unfinished = mutableMapOf<Int, Pair<String, Int>>()
    private val trip = mutableMapOf<String, Count>()

    fun checkIn(id: Int, stationName: String, t: Int) {
        unfinished[id] = stationName to t
    }

    fun checkOut(id: Int, stationName: String, t: Int) {
        val (s, t1) = unfinished[id]!!
        unfinished.remove(id)
        val newTrip = trip.getOrPut("$s-$stationName", { Count() })
        newTrip.sum += t - t1
        newTrip.c ++
    }

    fun getAverageTime(startStation: String, endStation: String): Double =
            trip["$startStation-$endStation"]!!.let { it.sum.toDouble() / it.c }
}