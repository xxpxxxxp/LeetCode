package com.ypwang.medium

class Solution3937 {
    fun minOperations(nums: IntArray, k: Int): Int {
        val n = nums.size
        var res = Int.MAX_VALUE
        for (i in 0 until k) {
            for (j in 0 until k) {
                if (i == j)
                    continue

                var ans = 0
                for (l in 0 until n) {
                    val target = if (l % 2 == 0) i else j
                    val diff = Math.abs((nums[l] % k) - target)
                    ans += minOf(diff, k - diff)
                }
                res = minOf(res, ans)
            }
        }

        return res
    }
}
