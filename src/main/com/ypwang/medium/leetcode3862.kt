package com.ypwang.medium

class Solution3862 {
    fun smallestBalancedIndex(nums: IntArray): Int {
        val n = nums.size
        val leftSum = LongArray(n)
        for (i in 1 until n)
            leftSum[i] = leftSum[i - 1] + nums[i - 1]

        var pro = 1L
        var ans = -1

        for (i in n - 1 downTo 0) {
            if (leftSum[i] == pro)
                ans = i
            if (i > 0) {
                if (pro > 1e14 / nums[i])
                    pro = 1e18.toLong()
                else
                    pro *= nums[i].toLong()
            }
        }
        return ans
    }
}
