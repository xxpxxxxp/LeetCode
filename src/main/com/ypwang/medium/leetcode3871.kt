package com.ypwang.medium

class Solution3871 {
    fun countCommas(n: Long): Long {
        var rst = 0L
        var base = 1000L
        var c = 1
        while (base <= n) {
            val diff = minOf(n + 1 - base, 999 * base)
            rst += diff * c
            base *= 1000L
            c++
        }

        return rst
    }
}

fun main() {
    println(Solution3871().countCommas(1002))
}