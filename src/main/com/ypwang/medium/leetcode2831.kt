package com.ypwang.medium

class Solution2831 {
    fun longestEqualSubarray(nums: List<Int>, k: Int): Int {
        var maxf = 0
        var i = 0
        val n = nums.size
        val count = mutableMapOf<Int, Int>()
        for ((j, v) in nums.withIndex()) {
            count[v] = count.getOrDefault(v, 0) + 1
            maxf = maxOf(maxf, count[v]!!)
            if (j - i + 1 - maxf > k) {
                count[nums[i]] = count[nums[i]]!! - 1
                i++
            }
        }
        return maxf
    }
}
