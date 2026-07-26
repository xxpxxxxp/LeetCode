package com.ypwang.medium

class Solution4002 {
    val MOD = 1000000007

    fun power(b: Long, e: Long): Long {
        var b = b
        var e = e
        var r = 1L
        while (e > 0) {
            if ((e and 1L) == 1L)
                r = r * b % MOD
            e = e shr 1
            b = b * b % MOD
        }
        return r
    }

    fun comb(n: Int, k: Int): Long {
        var k = k
        if (k !in 0..n)
            return 0
        k = minOf(k, n - k)
        var res = 1L
        var den = 1L
        for (i in 1..k) {
            res = res * (n - i + 1) % MOD
            den = den * i % MOD
        }
        return res * power(den, (MOD - 2).toLong()) % MOD
    }

    fun countValidSequences(n: Int, k: Int): Int {
        var res = comb(n - 1, k - 1)
        if (n % 2 == k % 2)
            res = (res - comb((n + k) / 2 - 1, k - 1) + MOD) % MOD
        return res.toInt()
    }
}
