package com.ypwang.medium

import java.lang.StringBuilder

class Solution2384 {
    fun largestPalindromic(num: String): String {
        val c = IntArray(10)
        for (i in num) {
            c[i - '0']++
        }
        val odd = c.withIndex().reversed().firstOrNull() { it.value % 2 == 1 }?.index
        val sb = StringBuilder()
        for ((i, v) in c.withIndex().reversed()) {
            if (i == 0 && sb.isEmpty())
                continue
            repeat(v / 2) {
                sb.append('0' + i)
            }
        }
        val s = sb.toString()
        if (odd == null) {
            if (s.isEmpty())
                return "0"
            return s + s.reversed()
        }
        return s + ('0' + odd) + s.reversed()
    }
}