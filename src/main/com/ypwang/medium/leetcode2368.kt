package com.ypwang.medium

import java.util.LinkedList
import java.util.Queue

class Solution2368 {
    fun reachableNodes(_n: Int, edges: Array<IntArray>, restricted: IntArray): Int {
        val e = edges.flatMap { listOf(it.toList(), it.toList().reversed()) }.groupBy { it[0] }.mapValues { it.value.map { l -> l[1] } }
        val r = restricted.toSet()
        val seen = mutableSetOf<Int>()
        val q: Queue<Int> = LinkedList()
        q.add(0)
        var c = 0

        while (q.isNotEmpty()) {
            c++
            val n = q.poll()
            seen.add(n)
            for (nn in e.getOrDefault(n, mutableListOf())) {
                if (nn !in r && nn !in seen) {
                    q.offer(nn)
                }
            }
        }

        return c
    }
}

fun main() {
    println(Solution2368().reachableNodes(7, arrayOf(
        intArrayOf(0,1),intArrayOf(1,2),intArrayOf(3,1),intArrayOf(4,0),intArrayOf(0,5),intArrayOf(5,6)
    ), intArrayOf(4,5)))
}