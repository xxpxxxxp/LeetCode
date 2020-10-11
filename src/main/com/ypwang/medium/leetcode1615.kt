package com.ypwang.medium

class Solution1615 {
    fun maximalNetworkRank(n: Int, roads: Array<IntArray>): Int {
        if (roads.isEmpty())
            return 0

        val count = IntArray(n)
        val road = mutableSetOf<Int>()

        for ((a, b) in roads) {
            count[a]++
            count[b]++

            road.add((minOf(a, b) shl 8) or maxOf(a, b))
        }

        val rank = count.withIndex()
                .groupBy { it.value }
                .mapValues { it.value.map { kv -> kv.index }.toTypedArray() }
                .toList()
                .sortedByDescending { it.first }

        val (max, n1) = rank.first()
        if (n1.size > 1) {
            for (i in n1.indices) {
                for (j in i+1 until n1.size) {
                    if (((n1[i] shl 8) or n1[j]) !in road)
                        return 2 * max
                }
            }

            return 2 * max - 1
        }

        val n1s = n1.single()
        val (next, n2) = rank[1]
        for (r in n2) {
            if (((minOf(n1s, r) shl 8) or maxOf(n1s, r)) !in road)
                return max + next
        }

        return max + next - 1
    }
}

fun main() {
    println(Solution1615().maximalNetworkRank(4, arrayOf(intArrayOf(0,1),intArrayOf(0,3),intArrayOf(1,2),intArrayOf(1,3))))
    println(Solution1615().maximalNetworkRank(5, arrayOf(intArrayOf(0,1),intArrayOf(0,3),intArrayOf(1,2),intArrayOf(1,3), intArrayOf(2,3), intArrayOf(2,4))))
    println(Solution1615().maximalNetworkRank(8, arrayOf(intArrayOf(0,1),intArrayOf(1,2),intArrayOf(2,3),intArrayOf(2,4), intArrayOf(5,6), intArrayOf(5,7))))
}