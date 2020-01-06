package com.ypwang.easy

import java.util.*

class Solution1299 {
    fun replaceElements(arr: IntArray): IntArray {
        val rst = IntArray(arr.size)
        val stack = Stack<Int>()

        for ((i, v) in arr.withIndex().reversed()) {
            if (stack.isEmpty() || arr[stack.peek()] < v)
                stack.push(i)
        }

        for (i in 0 until arr.size-1) {
            if (stack.peek() == i)
                stack.pop()

            rst[i] = arr[stack.peek()]
        }

        rst[rst.lastIndex] = -1
        return rst
    }
}

fun main() {
    println(Solution1299().replaceElements(intArrayOf(17,18,5,4,6,1)).toList())
}