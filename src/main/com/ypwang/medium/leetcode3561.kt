package com.ypwang.medium

class Solution3561 {
    fun resultingString(s: String): String {
        val stack = mutableListOf<Char>()
        for (c in s) {
            if (stack.isNotEmpty() && ((stack.last() - c + 26) % 26) in setOf(1, 25))
                stack.removeLast()
            else
                stack.add(c)
        }

        return stack.joinToString("")
    }
}
