package com.ypwang.medium

import java.util.*

class Solution5131 {
    fun mctFromLeafValues(arr: IntArray): Int {
        val stack = Stack<Int>()

        var rst = 0
        for (i in arr) {
            while (stack.isNotEmpty() && stack.peek() < i) {
                val t = stack.pop()
                var min = i
                if (stack.isNotEmpty() && stack.peek() < i) {
                    min = stack.peek()
                }
                rst += t * min
            }

            stack.add(i)
        }

        while (stack.size > 1) {
            val t = stack.pop()
            rst += t * stack.peek()
        }

        return rst
    }
}
