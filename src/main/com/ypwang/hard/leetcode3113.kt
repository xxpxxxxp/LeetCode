package com.ypwang.hard

import java.util.Stack

class Solution3113 {
    fun numberOfSubarrays(nums: IntArray): Long {
        val stack = Stack<IntArray>()
        var rst = 0L
        for (a in nums) {
            while (stack.isNotEmpty() && stack.peek()[0] < a)
                stack.pop()
            if (stack.isEmpty() || stack.peek()[0] != a)
                stack.push(intArrayOf(a, 0))
            rst += ++stack.peek()[1]
        }
        return rst
    }
}
