package com.ypwang.medium

import java.util.*

class Solution1856 {
    fun maxSumMinProduct(nums: IntArray): Int {
        val preSum = LongArray(nums.size+1)
        for (i in nums.indices) {
            preSum[i+1] = preSum[i] + nums[i]
        }

        val left = IntArray(nums.size)
        val right = IntArray(nums.size)
        val stack = Stack<Int>()

        for ((i, v) in nums.withIndex()) {
            while (stack.isNotEmpty() && nums[stack.peek()] >= v)
                stack.pop()

            left[i] = if (stack.isEmpty()) 0 else stack.peek()+1
            stack.push(i)
        }

        stack.clear()
        for ((i, v) in nums.withIndex().reversed()) {
            while (stack.isNotEmpty() && nums[stack.peek()] >= v)
                stack.pop()

            right[i] = if (stack.isEmpty()) nums.size else stack.peek()
            stack.push(i)
        }

        return (left.zip(right.withIndex()).map { (l, ir) -> nums[ir.index] * (preSum[ir.value] - preSum[l]) }.max()!! % 1000000007).toInt()
    }
}

fun main() {
    println(Solution1856().maxSumMinProduct(intArrayOf(1,2,3,2)))
}