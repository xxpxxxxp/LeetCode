package com.ypwang.easy

import java.util.*

class Solution1047 {
    fun removeDuplicates(S: String): String {
        val stack = Stack<Char>()

        for (c in S) {
            if (stack.isNotEmpty() && stack.peek() == c) {
                stack.pop()
            } else {
                stack.add(c)
            }
        }

        return stack.joinToString("")
    }
}