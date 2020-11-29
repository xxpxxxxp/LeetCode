package com.ypwang.medium

import java.util.*

class Solution1673 {
    fun mostCompetitive(nums: IntArray, k: Int): IntArray {
        val stack = Stack<Int>()

        for ((i, v) in nums.withIndex()) {
            while (stack.isNotEmpty() && v < stack.peek() && nums.size - i - 1 >= k - stack.size) {
                stack.pop()
            }
            if (stack.size < k) {
                stack.add(v)
            }
        }

        return stack.toIntArray()
    }
}

fun main() {
    println(Solution1673().mostCompetitive(intArrayOf(3,5,2,6), 2).toList())
    println(Solution1673().mostCompetitive(intArrayOf(2,4,3,3,5,4,9,6), 4).toList())
}