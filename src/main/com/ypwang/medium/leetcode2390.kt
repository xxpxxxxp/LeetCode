package com.ypwang.medium

import java.util.*

class Solution2390 {
    fun removeStars(s: String): String {
        val stack = Stack<Char>()

        for (c in s) {
            if (c != '*')
                stack.add(c)
            else if (stack.isNotEmpty())
                stack.pop()
        }

        return stack.joinToString("")
    }
}