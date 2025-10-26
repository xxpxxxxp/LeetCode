package com.ypwang.medium

class Solution3727 {
    fun maxAlternatingSum(nums: IntArray): Long {
        val s = nums.map { Math.abs(it) }.sortedDescending().toIntArray()
        val len = (nums.size + 1) / 2
        var rst = 0L
        for (i in 0 until len) {
            rst += s[i] * s[i]
            if (i+len < nums.size)
                rst -= s[i+len] * s[i+len]
        }

        return rst
    }
}
