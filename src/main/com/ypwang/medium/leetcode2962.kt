package com.ypwang.medium

class Solution2962 {
    fun countSubarrays(nums: IntArray, k: Int): Long {
        val a = nums.max()!!
        val n = nums.size
        var cur = 0
        var i = 0
        var res = 0L
        for (j in 0 until n) {
            cur += if (nums[j] == a) 1 else 0
            while (cur >= k)
                cur -= if (nums[i++] == a) 1 else 0
            res += i
        }
        return res
    }
}