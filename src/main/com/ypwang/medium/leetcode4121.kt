package com.ypwang.medium

class Solution4121 {
    fun minCost(nums: IntArray): Long {
        val n = nums.size
        var cnt = 0
        var res = Long.MAX_VALUE
        for (i in 0 until n) {
            cnt = if (i > 0 && nums[i] == nums[i - 1]) cnt + 1 else 1
            if (cnt > 1 || (0 < i && i < n - 1))
                res = minOf(res, 1L * (n - cnt) * nums[i])
        }
        return res
    }
}
