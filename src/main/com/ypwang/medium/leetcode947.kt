package com.ypwang.medium

class Solution947 {
    fun removeStones(stones: Array<IntArray>): Int {
        val ss = stones.map { Pair(it[0], it[1]) }.toMutableSet()

        val groups = listOf<List<Pair<Int, Int>>>()

        fun findRelated(point: Pair<Int, Int>, found: MutableSet<Pair<Int, Int>>) {
            val nl = ss.filter { it !in found && (it.first == point.first || it.second == point.second) }
            found.addAll(nl)
            nl.forEach { findRelated(it, found) }
        }

        var count = 0
        while (!ss.isEmpty()) {
            val p = ss.first()
            val f = mutableSetOf(p)
            findRelated(p, f)
            count += f.size - 1
            ss.removeAll(f)
        }

        return count
    }
}

fun main(args: Array<String>) {
    println(Solution947().removeStones(arrayOf(
            intArrayOf(0, 0), intArrayOf(0, 2), intArrayOf(1, 1), intArrayOf(2, 0), intArrayOf(2, 2)
    )))
}