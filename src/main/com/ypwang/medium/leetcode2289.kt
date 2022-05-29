package com.ypwang.medium

import java.util.*

class Solution2289 {
    fun totalSteps(nums: IntArray): Int {
        nums.reverse()
        val stack = Stack<Pair<Int, Int>>()
        stack.push(nums[0] to 0)

        var max = 0
        for (i in 1 until nums.size) {
            var cnt = 0
            while (stack.isNotEmpty() && stack.peek().first < nums[i])
                cnt = maxOf(cnt + 1, stack.pop().second)
            stack.push(nums[i] to cnt)
            max = maxOf(max, cnt)
        }

        return max
    }
}