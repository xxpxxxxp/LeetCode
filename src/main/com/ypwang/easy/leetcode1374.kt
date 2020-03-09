package com.ypwang.easy

import java.lang.Exception

class Solution1374 {
    fun generateTheString(n: Int): String =
        when (n % 2) {
            0 -> (0 until n-1). joinToString("") { "a" } + "b"
            1 -> (0 until n).joinToString("") { "a" }
            else -> throw Exception("impossible")
        }
}