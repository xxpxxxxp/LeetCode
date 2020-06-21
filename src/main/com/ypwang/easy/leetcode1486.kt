package com.ypwang.easy

class Solution1486 {
    fun xorOperation(n: Int, start: Int): Int = (0 until n).map { start + it * 2 }.reduce { acc, i -> acc xor i }
}