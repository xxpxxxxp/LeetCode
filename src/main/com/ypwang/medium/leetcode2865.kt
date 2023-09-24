package com.ypwang.medium

import java.util.*

class Solution2865 {
    fun maximumSumOfHeights(maxHeights: List<Int>): Long {
        val n = maxHeights.size
        val left = LongArray(n)
        val stack = Stack<Int>()
        stack.push(-1)
        var res = 0L
        var cur = 0L
        for (i in 0 until n) {
            while (stack.size > 1 && maxHeights[stack.peek()] > maxHeights[i]) {
                val j = stack.pop()
                cur -= (j - stack.peek()).toLong() * maxHeights[j]
            }
            cur += (i - stack.peek()).toLong() * maxHeights[i]
            stack.push(i)
            left[i] = cur
        }
        stack.clear()
        stack.push(n)
        cur = 0L
        for (i in n - 1 downTo 0) {
            while (stack.size > 1 && maxHeights[stack.peek()] > maxHeights[i]) {
                val j = stack.pop()
                cur -= (stack.peek() - j).toLong() * maxHeights[j]
            }
            cur += (stack.peek() - i).toLong() * maxHeights[i]
            stack.push(i)
            res = maxOf(res, (left[i] + cur - maxHeights[i]))
        }
        return res
    }
}
