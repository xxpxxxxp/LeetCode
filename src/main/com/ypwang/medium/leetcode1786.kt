package com.ypwang.medium

import java.util.*

class Solution1786 {
    fun countRestrictedPaths(n: Int, edges: Array<IntArray>): Int {
        val relations = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
        for ((a, b, w) in edges) {
            relations.getOrPut(a-1, { mutableListOf() }).add(b-1 to w)
            relations.getOrPut(b-1, { mutableListOf() }).add(a-1 to w)
        }

        val candidates = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        candidates.add(n-1 to 1)

        val distance = IntArray(n)
        var count = 0
        while (count < n) {
            val (idx, weight) = candidates.poll()
            if (distance[idx] != 0)
                continue

            distance[idx] = weight
            count++
            for ((i, w) in relations.getOrElse(idx, { mutableListOf() })) {
                if (distance[i] == 0) {
                    candidates.offer(i to weight + w)
                }
            }
        }

        val cache = IntArray(n) { -1 }
        // dfs
        fun dfs(idx: Int): Int {
            if (idx == n-1)
                return 1

            if (cache[idx] == -1) {
                cache[idx] = relations.getOrElse(idx, { mutableListOf() })
                    .map { it.first }
                    .filter { distance[idx] > distance[it] }
                    .map { dfs(it) }
                    .reduce { a, b -> (a + b) % 1000000007 }
            }

            return cache[idx]
        }

        return dfs(0)
    }
}

fun main() {
    println(Solution1786().countRestrictedPaths(5, arrayOf(
        intArrayOf(1,2,3),intArrayOf(1,3,3),intArrayOf(2,3,1),intArrayOf(1,4,2),intArrayOf(5,2,2),intArrayOf(3,5,1),intArrayOf(5,4,10)
    )))
}