package com.ypwang.medium

class Solution2187 {
    fun minimumTime(time: IntArray, totalTrips: Int): Long {
        var left = 1L
        var right = 100000000000000L

        while (left < right) {
            val mid = (left + right) / 2
            if (time.map { mid / it }.sum() < totalTrips)
                left = mid + 1
            else
                right = mid
        }

        return left
    }
}