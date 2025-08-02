package com.ypwang.medium

class Solution3440 {
    fun maxFreeTime(eventTime: Int, startTime: IntArray, endTime: IntArray): Int {
        val gap = IntArray(startTime.size + 1)
        val largestRight = IntArray(startTime.size + 1)
        gap[0] = startTime[0]
        for (i in 1 until startTime.size)
            gap[i] = startTime[i] - endTime[i - 1]
        gap[startTime.size] = eventTime - endTime[endTime.size - 1]

        for (i in gap.size - 2 downTo 0)
            largestRight[i] = maxOf(largestRight[i + 1], gap[i + 1])
        var ans = 0
        var largestLeft = 0
        for (i in 1 until gap.size) {
            val curGap = endTime[i - 1] - startTime[i - 1]
            if (largestLeft >= curGap || largestRight[i] >= curGap)
                ans = maxOf(ans, gap[i - 1] + gap[i] + curGap)
            ans = maxOf(ans, gap[i - 1] + gap[i])
            largestLeft = maxOf(largestLeft, gap[i - 1])
        }
        return ans
    }
}
