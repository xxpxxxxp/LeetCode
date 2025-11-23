package com.ypwang.easy

class Solution3754 {
    fun sumAndMultiply(n: Int): Long {
        val t = n.toString().filter { it != '0' }
        return if (t.isEmpty()) 0L else t.toLong() * t.sumOf { it - '0' }
    }
}
