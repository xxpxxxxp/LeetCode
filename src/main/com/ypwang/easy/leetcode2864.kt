package com.ypwang.easy

class Solution2864 {
    fun maximumOddBinaryNumber(s: String): String {
        val c1 = s.count { it == '1' }
        val c0 = s.length - c1
        return (0 until c1 - 1).joinToString(""){ "1" } + (0 until c0).joinToString(""){ "0" } + "1"
    }
}