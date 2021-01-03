package com.ypwang.medium

class Solution1711 {
    private val mod = 1000000007

    fun countPairs(deliciousness: IntArray): Int {
        val map = deliciousness.groupBy { it }.mapValues { it.value.size }
        var total = 0L

        for ((i, v) in map) {
            for (bit in 0..21) {
                val diff = (1 shl bit) - i
                if (diff == i) {
                    total = (total + v.toLong() * (v - 1) / 2) % mod
                } else if (diff > i && diff in map) {
                    total = (total + v.toLong() * map[diff]!!) % mod
                }
            }
        }

        return total.toInt()
    }
}

fun main() {
    println(Solution1711().countPairs(intArrayOf(1,1,1,3,3,3,7)))
}