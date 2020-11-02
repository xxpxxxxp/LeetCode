package com.ypwang.medium

class Solution1637 {
    fun maxWidthOfVerticalArea(points: Array<IntArray>): Int {
        val arr = points.map { it[0] }.distinct().sorted().toTypedArray()
        var max = Int.MIN_VALUE
        for (i in 1 until arr.size) {
            max = maxOf(arr[i] - arr[i-1], max)
        }

        return max
    }
}