package com.ypwang.medium

import java.util.Stack

class Solution3834 {
    fun mergeAdjacent(nums: IntArray): List<Long> {
        val stack = Stack<Long>()
        for (v in nums) {
            var n = v.toLong()
            while (stack.isNotEmpty() && stack.peek() == n) {
                stack.pop()
                n *= 2
            }
            stack.push(n)
        }
        return stack.toList()
    }
}
