package com.ypwang.medium

class Solution787 {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, K: Int): Int {
        val unvisited = IntArray(n){it}.toMutableSet()
        unvisited.add(src)
        val dist = List(n){ it to Int.MAX_VALUE }.toMap().toMutableMap()
        dist[src] = 0

        val flight = flights.map { it[0] to (it[1] to it[2]) }.groupBy { it.first }.mapValues { it.value.map { p -> p.second } }
        if (src in flight)
            flight[src]!!.forEach {
                if (dist[it.first]!! > it.second) dist[it.first] = it.second
            }

        var round = 0
        while (round < K && dst in unvisited) {
            for ((city, d) in dist.filter { it.key in flight && it.value != Int.MAX_VALUE }) {
                flight[city]!!.forEach {
                    if (dist[it.first]!! > d + it.second) dist[it.first] = d + it.second
                }
            }

            unvisited.remove(unvisited.map { it to dist[it]!! }.minByOrNull { it.second }!!.first)
            round++
        }

        return if (dist[dst]!! == Int.MAX_VALUE) -1 else dist[dst]!!
    }
}

fun main() {
    println(Solution787().findCheapestPrice(3, arrayOf(intArrayOf(0,1,100), intArrayOf(1,2,100), intArrayOf(0,2,500)), 0, 2, 0))
}