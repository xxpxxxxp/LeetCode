package com.ypwang.medium

import java.util.*

class Solution2104 {
    fun subArrayRanges(nums: IntArray): Long {
        var res = 0L
        val s = Stack<Int>()
        for (i in 0..nums.size) {
            while (s.isNotEmpty() && nums[s.peek()] > if (i == nums.size) Int.MIN_VALUE else nums[i]) {
                val j = s.pop()
                val k = if (s.isEmpty()) -1 else s.peek()
                res -= nums[j].toLong() * (i - j) * (j - k)
            }
            s.push(i)
        }

        s.clear()
        for (i in 0..nums.size) {
            while (s.isNotEmpty() && nums[s.peek()] < if (i == nums.size) Int.MAX_VALUE else nums[i]) {
                val j = s.pop()
                val k = if (s.isEmpty()) -1 else s.peek()
                res += nums[j].toLong() * (i - j) * (j - k)
            }
            s.push(i)
        }

        return res
    }
}

fun main() {
    println(Solution2104().subArrayRanges(intArrayOf(1,2,3)))
}