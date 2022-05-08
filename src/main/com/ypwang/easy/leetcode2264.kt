package com.ypwang.easy

class Solution2264 {
    fun largestGoodInteger(num: String): String =
        (9 downTo 0)
            .map { c -> (0 until 3).map { c }.joinToString("") }
            .firstOrNull { num.contains(it) }
            ?: ""
}