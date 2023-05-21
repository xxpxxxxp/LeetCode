package com.ypwang.easy

import java.util.*

class Solution2696 {
    fun minLength(s: String): Int {
        val stack = Stack<Char>()
        for (c in s) {
            if (c == 'B' && stack.isNotEmpty() && stack.peek() == 'A') {
                stack.pop()
                continue
            }
            if (c == 'D' && stack.isNotEmpty() && stack.peek() == 'C') {
                stack.pop()
                continue
            }
            stack.add(c)
        }
        return stack.size
    }
}