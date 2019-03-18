package com.ypwang.medium

class Solution279 {
    fun numSquares(n: Int): Int {
        val rst = Array(n+1){0}
        rst[1] = 1

        for (i in 2 .. n) {
            var j = 1
            var count = Int.MAX_VALUE

            while (j * j <= i) {
                if (rst[i - j * j] + 1 < count) {
                    count = rst[i - j * j] + 1
                }
                j++
            }

            rst[i] = count
        }

        return rst.last()
    }
}

fun main() {
    println(Solution279().numSquares(12))
}