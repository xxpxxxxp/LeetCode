package com.ypwang.medium

class Solution1722 {
    fun minimumHammingDistance(source: IntArray, target: IntArray, allowedSwaps: Array<IntArray>): Int {
        val dsu = IntArray(source.size){ it }

        fun root(i: Int): Int {
            if (i != dsu[i]) dsu[i] = root(dsu[i])
            return dsu[i]
        }

        fun union(i: Int, j: Int) {
            dsu[root(i)] = root(j)
        }

        for ((i, j) in  allowedSwaps)
            union(i, j)

        return source.indices
            .map { root(it) to it }
            .groupBy { it.first }
            .map { it.value.map { kv -> kv.second } }
            .sumBy { idx ->
                val s = idx.map { source[it] }.groupBy { it }.mapValues { it.value.size }
                val t = idx.map { target[it] }.groupBy { it }.mapValues { it.value.size }
                idx.size - s.map { minOf(it.value, t.getOrDefault(it.key, 0)) }.sum()
            }
    }
}

fun main() {
    println(Solution1722().minimumHammingDistance(
        intArrayOf(1,2,3,4), intArrayOf(2,1,4,5), arrayOf(intArrayOf(0,1), intArrayOf(2,3))
    ))
    println(Solution1722().minimumHammingDistance(
        intArrayOf(1,2,3,4), intArrayOf(1,3,2,4), arrayOf()
    ))
    println(Solution1722().minimumHammingDistance(
        intArrayOf(5,1,2,4,3), intArrayOf(1,5,4,2,3), arrayOf(intArrayOf(0,4),intArrayOf(4,2),intArrayOf(1,3),intArrayOf(1,4))
    ))
}