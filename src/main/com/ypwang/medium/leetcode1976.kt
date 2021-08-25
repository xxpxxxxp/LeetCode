package com.ypwang.medium

import java.util.*

class Solution1976 {
    fun countPaths(n: Int, roads: Array<IntArray>): Int {
        val map = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()

        for ((a, b, c) in roads) {
            map.getOrPut(a) { mutableListOf() }.add(b to c)
            map.getOrPut(b) { mutableListOf() }.add(a to c)
        }

        // dist, idx
        val heap = PriorityQueue(compareBy<Pair<Long, Int>> { it.first })
        heap.add(0L to 0)

        val dist = LongArray(n) { Long.MAX_VALUE }
        val ways = LongArray(n)
        ways[0] = 1L

        while (heap.isNotEmpty()) {
            val (d, id) = heap.poll()
            if (d > dist[id])
                continue

            for ((idn, road) in map.getOrDefault(id, mutableListOf())) {
                val nd = d + road
                if (dist[idn] > nd) {
                    dist[idn] = nd
                    ways[idn] = ways[id]
                    heap.offer(dist[idn] to idn)
                } else if (nd == dist[idn])
                    ways[idn] = (ways[idn] + ways[id]) % 1000000007
            }
        }

        return ways.last().toInt()
    }
}

fun main() {
    println(Solution1976().countPaths(7, arrayOf(
        intArrayOf(0,6,7),intArrayOf(0,1,2),intArrayOf(1,2,3),intArrayOf(1,3,3),intArrayOf(6,3,3),intArrayOf(3,5,1),intArrayOf(6,5,1),intArrayOf(2,5,1),intArrayOf(0,4,5),intArrayOf(4,6,2)
    )))
}