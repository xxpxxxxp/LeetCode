package com.ypwang.hard

class Solution2561 {
    fun minCost(basket1: IntArray, basket2: IntArray): Long {
        val cnt = mutableMapOf<Int, Int>()
        basket1.forEach { cnt[it] = cnt.getOrDefault(it, 0) + 1 }
        basket2.forEach { cnt[it] = cnt.getOrDefault(it, 0) - 1 }

        val last = mutableListOf<Int>()
        for ((k, v) in cnt) {
            if (v % 2 != 0)
                return -1
            repeat(Math.abs(v) / 2) { last.add(k) }
        }
        last.sort()
        val minx = minOf(basket1.min(), basket2.min())
        var res = 0L
        for (i in 0 until last.size / 2)
            res += minOf(last[i], minx * 2)
        return res
    }
}