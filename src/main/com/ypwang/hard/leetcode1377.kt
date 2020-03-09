package com.ypwang.hard

import java.util.*

class Solution1377 {
    fun frogPosition(n: Int, edges: Array<IntArray>, t: Int, target: Int): Double {
        val edgeMap = edges.flatMap { listOf(it[0] to it[1], it[1] to it[0]) }
                .groupBy { it.first }
                .mapValues { it.value.map { kv -> kv.second } }
                .toMap()

        if (target == 1) return if (1 !in edgeMap) 1.0 else 0.0
        if (target !in edgeMap) return 0.0

        var bfs: Queue<Pair<Int, Double>> = LinkedList()
        bfs.add(1 to 1.0)
        var step = 0

        while (bfs.isNotEmpty()) {
            if (step > t) return 0.0

            val next = LinkedList<Pair<Int, Double>>()
            for ((id, probability) in bfs) {
                if (id == target) {
                    // only if its last step, or nowhere to go anymore
                    return if (step == t || edgeMap[target]!!.size == 1) probability else 0.0
                }
                if (id in edgeMap) {
                    val connected = edgeMap[id]!!
                    var size = connected.size
                    if (id != 1) size--
                    var np = probability / size
                    next.addAll(connected.map { it to np })
                }
            }

            step++
            bfs = next
        }

        return 0.0
    }
}

fun main() {
    println(Solution1377().frogPosition(7, arrayOf(
            intArrayOf(1,2), intArrayOf(1,3), intArrayOf(1,7), intArrayOf(2,4), intArrayOf(2,6), intArrayOf(3,5)
    ), 2, 4))
}