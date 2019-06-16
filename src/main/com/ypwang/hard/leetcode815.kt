package com.ypwang.hard

import java.util.*

class Solution815 {
    fun numBusesToDestination(routes: Array<IntArray>, S: Int, T: Int): Int {
        if (S == T) return 0

        val r = routes.map { it.toSet() }.toTypedArray()

        var max = Int.MAX_VALUE
        var count = 0

        val graph = Array(r.size) { mutableListOf<Int>() }

        for (i in 0 until r.lastIndex) {
            for (j in i+1 until r.size) {
                if (r[i].intersect(r[j]).isNotEmpty()) {
                    graph[i].add(j)
                    graph[j].add(i)
                }
            }
        }

        val seen = IntArray(r.size){ Int.MAX_VALUE }
        val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
        for ((i, n) in r.withIndex()) {
            if (S in n) {
                queue.offer(1 to i)
                seen[i] = 1
            }
        }

        while (queue.isNotEmpty()) {
            val (depth, i) = queue.poll()
            if (T in r[i]) return depth

            for (j in graph[i]) {
                if (seen[j] == Int.MAX_VALUE) {
                    seen[j] = depth + 1
                    queue.offer(depth+1 to j)
                }
            }
        }

        return -1
    }
}

fun main() {
    println(Solution815().numBusesToDestination(arrayOf(
            intArrayOf(1,2,7), intArrayOf(3,6,7)
    ),1, 6))
}