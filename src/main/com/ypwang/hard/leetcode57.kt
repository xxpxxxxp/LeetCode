package com.ypwang.hard

class Solution57 {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        var window: IntArray? = newInterval

        val rst = mutableListOf<IntArray>()
        for (interval in intervals) {
            if (window == null) rst.add(interval)
            else {
                if (window[1] < interval[0]) {
                    rst.add(window)
                    window = null
                    rst.add(interval)
                } else if (interval[1] < window[0]) {
                    rst.add(interval)
                } else {
                    window = intArrayOf(minOf(window[0], interval[0]), maxOf(window[1], interval[1]))
                }
            }
        }

        if (window != null) {
            rst.add(window)
        }

        return rst.toTypedArray()
    }
}