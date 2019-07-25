package com.ypwang.medium

class Solution1124 {
    fun longestWPI(hours: IntArray): Int {
        val rst = mutableMapOf<Int, Int>()
        var sum = 0
        var dis = 0

        for ((i, h) in hours.withIndex()) {
            sum += if (h > 8) 1 else -1
            if (sum !in rst) rst[sum] = i
            if (sum > 0) {
                if (i+1 > dis) dis = i+1
            } else {
                if (sum-1 in rst && i-rst[sum-1]!! > dis) {
                    dis = i-rst[sum-1]!!
                }
            }
        }

        return dis
    }
}