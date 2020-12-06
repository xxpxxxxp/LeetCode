package com.ypwang.medium

class Solution1680 {
    private val mod = 1000000007

    fun concatenatedBinary(n: Int): Int {
        var m = 1
        var rst = 0

        for (i in n downTo 1) {
            var j = i
            while (j != 0) {
                if (j % 2 == 1) {
                    rst = (rst + m) % mod
                }
                j /= 2
                m = (m * 2) % mod
            }
        }

        return rst
    }
}

fun main() {
    println(Solution1680().concatenatedBinary(12))
}