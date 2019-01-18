package com.ypwang.medium

class Solution495 {
    fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
        if (timeSeries.isEmpty()) {
            return 0
        }

        var count = 0

        for (i in 1 until timeSeries.size) {
            if (timeSeries[i] - timeSeries[i-1] >= duration) {
                count += duration
            } else {
                count += timeSeries[i] - timeSeries[i-1]
            }
        }

        return count + duration
    }
}