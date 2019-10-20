package com.ypwang.medium

class Solution1229 {
    fun minAvailableDuration(slots1: Array<IntArray>, slots2: Array<IntArray>, duration: Int): List<Int> {
        slots1.sortBy { it[0] }
        slots2.sortBy { it[1] }

        var i = 0
        var j = 0

        while (i < slots1.size && j < slots2.size) {
            val (s1b, s1e) = slots1[i]
            val (s2b, s2e) = slots2[j]

            val b = maxOf(s1b, s2b)
            val e = minOf(s1e, s2e)
            if (b + duration <= e) return listOf(b, b+duration)
            if (s1e < s2e) i++ else j++
        }

        return listOf()
    }
}

fun main() {
    println(Solution1229().minAvailableDuration(arrayOf(intArrayOf(10,50), intArrayOf(60,120), intArrayOf(140,210)), arrayOf(intArrayOf(0,15), intArrayOf(60,70)), 8))
    println(Solution1229().minAvailableDuration(arrayOf(intArrayOf(10,50), intArrayOf(60,120), intArrayOf(140,210)), arrayOf(intArrayOf(0,15), intArrayOf(60,70)), 12))
}