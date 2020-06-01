package com.ypwang.medium

class Solution1466 {
    fun minReorder(n: Int, connections: Array<IntArray>): Int {
        val map = mutableMapOf<Int, MutableList<Pair<Int, Boolean>>>()

        for ((from, to) in connections) {
            map.getOrPut(from, { mutableListOf() }).add(to to true)
            map.getOrPut(to, { mutableListOf() }).add(from to false)
        }

        var count = 0
        var queue = listOf(0)
        val seen = BooleanArray(n)

        while (queue.isNotEmpty()) {
            queue.forEach { seen[it] = true }
            val next = mutableListOf<Int>()

            for (city in queue) {
                for ((c, b) in map.getOrDefault(city, mutableListOf())) {
                    if (!seen[c]) {
                        next.add(c)
                        if (b) count++
                    }
                }
            }

            queue = next
        }

        return count
    }
}

fun main() {
    println(Solution1466().minReorder(6, arrayOf(
            intArrayOf(0,1), intArrayOf(1,3), intArrayOf(2,3), intArrayOf(4,0), intArrayOf(4,5)
    )))
}