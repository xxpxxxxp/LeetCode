package com.ypwang.medium

class Solution2550 {
    fun monkeyMove(n: Int): Int {
        var n = n
        var res = 1L
        var base = 2L
        val mod = 1000000007
        while (n > 0) {
            if (n % 2 == 1)
                res = res * base % mod
            base = base * base % mod
            n /= 2
        }
        return ((res - 2 + mod) % mod).toInt()
    }
}