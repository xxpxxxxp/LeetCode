package com.ypwang.hard

class Solution3041 {
    fun maxSelectedElements(nums: IntArray): Int {
        nums.sort()
        var rst = 0
        val dp = mutableMapOf<Int, Int>()
        for (a in nums) {
            dp[a + 1] = dp.getOrDefault(a, 0) + 1
            dp[a] = dp.getOrDefault(a - 1, 0) + 1
            rst = maxOf(rst, dp[a]!!, dp[a + 1]!!)
        }
        return rst
    }
}
