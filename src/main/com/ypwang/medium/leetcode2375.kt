package com.ypwang.medium

class Solution2375 {
    fun smallestNumber(pattern: String): String {
        val res = StringBuilder()
        val stack = StringBuilder()
        for (i in 0..pattern.length) {
            stack.append('1' + i)
            if (i == pattern.length || pattern[i] == 'I') {
                res.append(stack.reverse())
                stack.clear()
            }
        }
        return res.toString()
    }
}