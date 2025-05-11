package com.ypwang.medium

import java.util.*

class Solution3542 {
    fun minOperations(nums: IntArray): Int {
        val stack = Stack<Int>()
        stack.push(0)
        var res = 0
        for (a in nums) {
            while (stack.isNotEmpty() && stack.peek() > a)
                stack.pop()

            if (stack.isEmpty() || stack.peek() < a) {
                res++
                stack.push(a)
            }
        }
        return res
    }
}
