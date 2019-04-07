package com.ypwang.medium

import java.lang.StringBuilder

class Solution1017 {
    fun baseNeg2(N: Int): String {
        if (N == 0)
            return "0"

        var n = N
        val rst = StringBuilder()
        while (n != 0) {
            when (n % 4) {
                0 -> {
                    rst.append("00")
                    n /= 4
                }
                1 -> {
                    rst.append("10")
                    n = (n - 1) / 4
                }
                2 -> {
                    rst.append("01")
                    n = (n + 2) / 4
                }
                3 -> {
                    rst.append("11")
                    n = (n + 1) / 4
                }
            }
        }

        return rst.toString().reversed().dropWhile { it == '0' }
    }
}

fun main() {
    val t = Solution1017()
    println(t.baseNeg2(4))
    println(t.baseNeg2(200))
    println(t.baseNeg2(65537))
    println(t.baseNeg2(1e9.toInt()))
    println(t.baseNeg2(30589323))
    println(t.baseNeg2(10))
}