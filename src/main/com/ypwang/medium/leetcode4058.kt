package com.ypwang.medium

class Solution4058 {
    fun maxValue(nums: IntArray): Long {
        val n = nums.size

        var ans = 1e18.toLong()
        var s = 0L

        var e = 0L
        var o = -1e18.toLong()

        for (i in 0 until n) {

            // Alternating prefix sum
            s += if (i % 2 == 0) nums[i].toLong() else -nums[i].toLong()

            if ((i + 1) % 2 == 0) {
                ans = minOf(s - e, ans)
                e = maxOf(e, s)
            } else {
                ans = minOf(s - o, ans)
                o = maxOf(o, s)
            }
        }

        // Apply the best possible improvement
        s -= 2L * minOf(0L, ans)

        return s
    }
}
