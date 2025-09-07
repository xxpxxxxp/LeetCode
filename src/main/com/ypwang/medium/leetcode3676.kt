package com.ypwang.medium

import java.util.*

class Solution3676 {
    fun bowlSubarrays(nums: IntArray): Long {
        var res = 0L
        val s = Stack<Int>()
        for ((r, a) in nums.withIndex()) {
            while (s.isNotEmpty() && nums[s.peek()] <= a) {
                val l = s.pop()!!
                if (r - l + 1 >= 3)
                    res += 1
            }
            if (s.isNotEmpty() && r - s.peek()!! + 1 >= 3)
                res += 1
            s.push(r)
        }
        return res
    }
}
