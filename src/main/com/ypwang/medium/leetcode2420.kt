package com.ypwang.medium

class Solution2420 {
    fun goodIndices(nums: IntArray, k: Int): List<Int> {
        val n = nums.size
        val dec = IntArray(n)
        val inc = IntArray(n)
        val ans = mutableListOf<Int>()
        var pre = nums[0]
        var len = 0
        for ((i, v) in nums.withIndex()) {
            if (v <= pre)
                len++
            else len = 1
            pre = v
            dec[i] = len
        }
        len = 0
        pre = nums[0]
        for ((i, v) in nums.withIndex()) {
            if (v >= pre)
                len++
            else
                len = 1
            pre = v
            inc[i] = len
        }
        for (i in k until n - k) {
            if (dec[i - 1] >= k && inc[i + k] >= k)
                ans.add(i)
        }
        return ans
    }
}