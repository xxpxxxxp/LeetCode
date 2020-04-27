package com.ypwang.easy

class Solution1422 {
    fun maxScore(s: String): Int {
        val ones = s.count { it == '1' }

        var zero = 0
        var max = 0
        for (i in 1 until s.length) {
            if (s[i-1] == '0') zero++
            max = maxOf(max, 2 * zero + ones - i)
        }

        return max
    }
}

fun main() {
    println(Solution1422().maxScore("011101"))
    println(Solution1422().maxScore("00"))
}