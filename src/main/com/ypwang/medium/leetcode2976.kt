package com.ypwang.medium

import java.util.PriorityQueue

class Solution2976 {
    fun minimumCost(source: String, target: String, original: CharArray, changed: CharArray, cost: IntArray): Long {
        val paths = original.zip(changed.zip(cost.toList())).groupBy { it.first }.mapValues { it.value.map { p -> p.second }.sortedBy { p -> p.second } }

        val cache = mutableMapOf<String, Int>()

        fun findPath(from: Char, to: Char): Int {
            if (from == to)
                return 0

            val key = "$from$to"
            if (key in cache)
                return cache[key]!!

            val heap = PriorityQueue<Pair<Char, Int>>(compareBy { it.second })
            heap.addAll(paths.getOrDefault(from, listOf()))

            val seen = mutableListOf(from)

            while (heap.isNotEmpty()) {
                val (c, fee) = heap.poll()

                if (c in seen)
                    continue

                if (c == to) {
                    cache[key] = fee
                    return fee
                }

                seen.add(c)
                for ((nc, nfee) in paths.getOrDefault(c, listOf()))
                    heap.add(nc to fee + nfee)
            }

            return -1
        }

        return source.zip(target).map {
            val diff = findPath(it.first, it.second)
            if (diff == -1)
                return -1

            diff
        }.fold(0L) { a, b -> a + b }
    }
}

fun main() {
    println(Solution2976().minimumCost("abcd", "acbe", charArrayOf('a','b','c','c','e','d'), charArrayOf('b','c','b','e','b','e'), intArrayOf(2,5,5,1,2,20)))
}