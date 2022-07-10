package com.ypwang.hard

import java.util.*

class Solution2334 {
    fun validSubarraySize(nums: IntArray, threshold: Int): Int {
        val arr = IntArray(nums.size + 1) {
            if (it in nums.indices)
                threshold / nums[it] + 1
            else
                Int.MAX_VALUE
        }

        val stack = Stack<IntArray>()
        for (v in arr) {
            var count = 0
            while (stack.isNotEmpty() && stack.peek()[0] < v) {
                count += stack.peek()[1]
                if (count >= stack.peek()[0])
                    return count
                stack.pop()
            }
            stack.push(intArrayOf(v, count+1))
        }
        return -1
    }
}