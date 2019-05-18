package com.ypwang.hard

class Solution32 {
    fun longestValidParentheses(s: String): Int {
        val pos = mutableMapOf(0 to Pair(-1, 0))

        var max = 0
        var stack = 0
        for (i in 0 until s.length) {
            val right = s[i] == ')'
            if (right) stack-- else stack++

            if (stack in pos && right) {     // decreased to current value
                val p = pos[stack]!!
                val len = i - p.first + p.second
                max = maxOf(max, len)
                pos[stack] = i to len
            } else {
                if (stack < 0) stack = 0
                pos[stack] = i to 0
            }
        }

        return max
    }
}

fun main() {
    println(Solution32().longestValidParentheses(")()())"))
}
