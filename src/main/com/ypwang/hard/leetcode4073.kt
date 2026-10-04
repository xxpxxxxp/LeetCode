package com.ypwang.hard

class Solution4073 {
    val MOD = 1000000007L

    fun countGoodStrings(n: Long): Int =
        (2 * fibonacci(n)[0] % MOD).toInt()

    // Returns {F(n), F(n + 1)}
    private fun fibonacci(n: Long): LongArray {
        if (n == 0L)
            return longArrayOf(0, 1)

        val half = fibonacci(n / 2)

        val a = half[0] // F(k)
        val b = half[1] // F(k + 1)

        // F(2k) = F(k) * (2 * F(k + 1) - F(k))
        val c = a * ((2 * b % MOD - a + MOD) % MOD) % MOD

        // F(2k + 1) = F(k)^2 + F(k + 1)^2
        val d = (a * a % MOD + b * b % MOD) % MOD

        if (n % 2 == 0L)
            return longArrayOf(c, d)

        return longArrayOf(d, (c + d) % MOD)
    }
}
