package com.ypwang.easy

class Solution3099 {
    fun sumOfTheDigitsOfHarshadNumber(x: Int): Int {
        val s = x.toString().map { it - '0' }.sum()
        return if (x % s == 0) s else -1
    }
}
