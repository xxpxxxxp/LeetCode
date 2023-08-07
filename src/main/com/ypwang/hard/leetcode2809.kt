package com.ypwang.hard

class Solution2809 {
    fun minimumTime(nums1: List<Int>, nums2: List<Int>, x: Int): Int {
        val n = nums1.size
        val sum1 = nums1.sum()
        val sum2 = nums2.sum()
        val ba = nums2.zip(nums1).sortedBy { it.first }
        val dp = IntArray(n+1)

        for (j in 0 until n) {
            val (a, b) = ba[j]
            for (i in j + 1 downTo 1)
                dp[i] = maxOf(dp[i], dp[i - 1] + i * a + b)
        }

        for (i in 0..n)
            if (sum2 * i + sum1 - dp[i] <= x)
                return i

        return -1
    }
}