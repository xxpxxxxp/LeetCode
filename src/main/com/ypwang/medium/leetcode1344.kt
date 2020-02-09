package com.ypwang.medium

class Solution1344 {
    fun angleClock(hour: Int, minutes: Int): Double {
        val angleHour = hour * 30 + minutes / 2.0
        val angleMinute = minutes * 6.0

        val diff = Math.abs(angleHour - angleMinute)
        return minOf(diff, 360 - diff)
    }
}