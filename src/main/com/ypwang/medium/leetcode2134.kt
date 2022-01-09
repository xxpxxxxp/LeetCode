package com.ypwang.medium

class Solution2134 {
    fun minSwaps(nums: IntArray): Int {
        val c = nums.count { it == 1 }

        var cur = nums.take(c).count { it == 0 }
        var rst = cur
        for (i in 0 until nums.size) {
            if (nums[i] == 1)
                cur++
            if (nums[(i + c) % nums.size] == 1)
                cur--

            rst = minOf(rst, cur)
        }

        return rst
    }
}