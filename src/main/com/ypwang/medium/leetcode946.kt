package com.ypwang.medium

import java.util.Stack

class Solution946 {
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        val stack = Stack<Int>()

        var i = 0
        for (x in pushed) {
            stack.push(x)

            while (!stack.isEmpty() && i < popped.size && stack.peek() == popped[i]) {
                stack.pop()
                i++
            }
        }

        return i == popped.size
    }
}