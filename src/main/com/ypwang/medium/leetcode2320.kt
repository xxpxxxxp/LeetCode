package com.ypwang.medium

class Solution2320 {
    fun countHousePlacements(n: Int): Int {
        var a = 1L
        var b = 4L
        var c = 1L
        val mod = 1000000007L
        if (n == 1) return 4
        for (i in 2..n) {
            val tmp = (2L * a + 2L * b - c + mod) % mod
            c = a
            a = b
            b = tmp
        }
        return b.toInt()
    }
}