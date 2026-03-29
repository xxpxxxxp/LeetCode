package com.ypwang.medium

class Solution3881 {
    val MOD = 1e9.toInt() + 7

    fun pow(a: Long, b: Long): Long {
        var a = a
        var b = b
        var res = 1L
        while (b > 0) {
            if ((b and 1L) == 1L)
                res = (res * a) % MOD
            a = (a * a) % MOD
            b = b shr 1
        }
        return res
    }

    fun countVisiblePeople(n: Int, pos: Int, k: Int): Int {
        val fact = LongArray(n + 1)
        val inv = LongArray(n + 1)

        fact[0] = 1
        for (i in 1..n)
            fact[i] = fact[i - 1] * i % MOD

        inv[n] = pow(fact[n], (MOD - 2).toLong())
        for (i in n - 1 downTo 0)
            inv[i] = inv[i + 1] * (i + 1) % MOD

        fun comb(n: Int, r: Int): Long =
            fact[n] * inv[r] % MOD * inv[n - r] % MOD

        val left = pos
        val right = n - pos - 1
        var ans = 0L

        for (i in maxOf(0, k - right)..minOf(left, k))
            ans = (ans + comb(left, i) * comb(right, k - i)) % MOD

        return ((ans * 2) % MOD).toInt()
    }
}
