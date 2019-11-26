package com.ypwang.hard

import java.util.*

class Solution882 {
    fun reachableNodes(edges: Array<IntArray>, M: Int, N: Int): Int {
        val paths = edges.flatMap { listOf(it[0] to (it[1] to it[2]), it[1] to (it[0] to it[2])) }.groupBy { it.first }
                .mapValues { it.value.map { p -> p.second } }.toMap()

        if (0 !in paths) return minOf(1, M)

        val dist = IntArray(N){ Int.MAX_VALUE }
        val queue = PriorityQueue<Pair<Int, Int>>(kotlin.Comparator { p1, p2 -> p1.second - p2.second })
        queue.offer(0 to 0)

        while (queue.isNotEmpty()) {
            val (idx, d) = queue.poll()
            if (d >= dist[idx]) continue
            dist[idx] = d

            if (idx in paths) {
                for ((nidx, a) in paths[idx]!!) {
                    if (d + a + 1 > M) continue
                    queue.offer(nidx to d + a + 1)
                }
            }
        }

        var sum = 0
        val cache = mutableMapOf<Int, Int>()
        for (i in 0 until N) {
            if (dist[i] <= M) {
                for ((nidx, a) in paths[i]!!) {
                    val key = (minOf(i, nidx) shl 16) + maxOf(i, nidx)
                    val visited = cache.getOrDefault(key, 0)
                    val canVisit = minOf(M - dist[i], a - visited)
                    sum += canVisit
                    cache[key] = visited + canVisit
                }
                sum += 1
            }
        }

        return sum
    }
}

fun main() {
    println(Solution882().reachableNodes(arrayOf(
            intArrayOf(1,2,5), intArrayOf(0,3,3), intArrayOf(1,3,2), intArrayOf(2,3,4), intArrayOf(0,4,1)
    ), 7, 5))

    println(Solution882().reachableNodes(arrayOf(
            intArrayOf(0,1,4), intArrayOf(1,2,6), intArrayOf(0,2,8), intArrayOf(1,3,1)
    ), 10, 4))

    println(Solution882().reachableNodes(arrayOf(
            intArrayOf(0,1,10), intArrayOf(0,2,1), intArrayOf(1,2,2)
    ), 6, 3))
}