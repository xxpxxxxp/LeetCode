package com.ypwang.medium

import java.util.Stack

class Solution456 {
    class Pair(var min: Int, var max: Int)
    fun find132pattern(nums: IntArray): Boolean {
        val stack = Stack<Pair>()
        for (n in nums) {
            if (stack.isEmpty() || n < stack.peek().min)
                stack.push(Pair(n, n))
            else if (n > stack.peek().min) {
                val last = stack.pop()
                if (n < last.max)
                    return true
                else {
                    last.max = n
                    while (!stack.isEmpty() && n >= stack.peek().max) stack.pop()
                    // At this time, n < stack.peek().max (if stack not empty)
                    if (!stack.isEmpty() && stack.peek().min < n) return true
                    stack.push(last)
                }

            }
        }
        return false
    }
}