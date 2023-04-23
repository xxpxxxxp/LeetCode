package com.ypwang.medium

class Solution2653 {
    fun getSubarrayBeauty(nums: IntArray, k: Int, x: Int): IntArray {
        val counter = IntArray(50)
        val ans = IntArray(nums.size - k + 1)
        for ((i, v) in nums.withIndex()) {
            if (v < 0)
                counter[v + 50]++
            if (i - k >= 0 && nums[i - k] < 0)
                counter[nums[i - k] + 50]--
            if (i - k + 1 < 0)
                continue

            var count = 0
            for (j in 0..49) {
                count += counter[j]
                if (count >= x) {
                    ans[i - k + 1] = j - 50
                    break
                }
            }
        }
        return ans
    }
}