package com.ypwang.medium

class Solution3439 {
    fun maxFreeTime(eventTime: Int, k: Int, startTime: IntArray, endTime: IntArray): Int {
        val n = startTime.size
        val gaps = IntArray(n + 1)

        // Calculate the first and last gap separately
        gaps[0] = startTime[0]  // Free time before the first meeting
        gaps[n] = eventTime - endTime[n - 1]  // Free time after the last meeting

        // Compute gaps between meetings
        for (i in 1 until n)
            gaps[i] = startTime[i] - endTime[i - 1]

        // Compute prefix sum for efficient range sum calculation
        val pref = IntArray(n + 2)
        for (i in 1..n + 1)
            pref[i] = pref[i - 1] + gaps[i - 1]

        // Sliding window to find the maximum sum of k+1 consecutive gaps
        var rst = 0
        for (i in k + 1..n + 1)
            rst = maxOf(rst, pref[i] - pref[i - (k + 1)])

        return rst
    }
}
