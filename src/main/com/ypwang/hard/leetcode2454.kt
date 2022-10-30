package com.ypwang.hard

import java.util.*

class Solution2454 {
    fun secondGreaterElement(nums: IntArray): IntArray {
        val rst = IntArray(nums.size) { -1 }
        val s1 = Stack<Int>()
        val s2 = Stack<Int>()
        val tmp = Stack<Int>()
        for ((i, n) in nums.withIndex()) {
            while (s2.isNotEmpty() && nums[s2.peek()] < n)
                rst[s2.pop()] = n

            while (s1.isNotEmpty() && nums[s1.peek()] < n)
                tmp.push(s1.pop())

            s1.push(i)

            while (tmp.isNotEmpty())
                s2.push(tmp.pop())
        }
        return rst
    }
}