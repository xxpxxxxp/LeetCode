package com.ypwang.easy

import java.util.*

class Solution3174 {
    fun clearDigits(s: String): String {
        val stack = Stack<Char>()

        for (c in s)
            if (c.isDigit())
                stack.pop()
            else
                stack.push(c)

        return stack.joinToString("")
    }
}
