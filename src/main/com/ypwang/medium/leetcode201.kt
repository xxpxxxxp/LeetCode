package com.ypwang.medium

class Solution201 {
    fun rangeBitwiseAnd(m: Int, n: Int): Int {
        if (n - m < 64) {
            return (m..n).reduce { acc, i -> acc and i }
        }

        var i = 0
        for (j in 0 until 32) {
            val range = (1 shl j) until (1 shl j+1)
            if (m in range && n in range) {
                i = i or 1 shl j
            }
        }

        return i
    }
}

fun main() {
    println(Solution201().rangeBitwiseAnd(5, 7))
}