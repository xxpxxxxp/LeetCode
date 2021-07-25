package com.ypwang.hard

import java.util.*

class Solution1944 {
    fun canSeePersonsCount(heights: IntArray): IntArray {
        val stack = Stack<Int>()
        val rst = IntArray(heights.size)

        for ((idx, v) in heights.withIndex().reversed()) {
            var count = 0

            while (stack.isNotEmpty() && stack.peek() < v) {
                stack.pop()
                count++
            }

            if (stack.isNotEmpty())
                count++

            stack.push(v)

            rst[idx] = count
        }

        return rst
    }
}

fun main() {
    println(Solution1944().canSeePersonsCount(intArrayOf(10,6,8,5,11,9)).toList())
}