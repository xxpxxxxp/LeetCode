package com.ypwang.medium

class Solution2749 {
    fun makeTheIntegerZero(num1: Int, num2: Int): Int =
        (0..60).firstOrNull { k ->
            val t = num1 - k.toLong() * num2
            t > 0 && k in java.lang.Long.bitCount(t)..t
        } ?: -1
}