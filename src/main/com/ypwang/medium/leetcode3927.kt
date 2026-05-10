package com.ypwang.medium

class Solution3927 {
    fun minArraySum(nums: IntArray): Long {
        var rst = 0L
        var t = nums.sorted()

        while (t.isNotEmpty()) {
            val head = t.first()
            val next = t.filter { it % head != 0 }
            rst += head.toLong() * (t.size - next.size)

            t = next
        }

        return rst
    }
}
