package com.ypwang.hard

class Solution3426 {
    private fun comb(a: Long, b: Long, mod: Long): Long {
        if (b > a) return 0
        var numer = 1L
        var denom = 1L
        for (i in 0 until b) {
            numer = numer * (a - i) % mod
            denom = denom * (i + 1) % mod
        }
        // Fermat's Little Theorem
        var denomInv = 1L
        var exp = mod - 2
        while (exp > 0) {
            if (exp % 2 > 0) {
                denomInv = denomInv * denom % mod
            }
            denom = denom * denom % mod
            exp /= 2
        }
        return numer * denomInv % mod
    }

    fun distanceSum(m: Int, n: Int, k: Int): Int {
        var res = 0L
        val mod = 1000000007L
        val base = comb((m * n - 2).toLong(), (k - 2).toLong(), mod)
        for (d in 1 until n)
            res = (res + 1L * d * (n - d) % mod * m % mod * m % mod) % mod
        for (d in 1 until m)
            res = (res + 1L * d * (m - d) % mod * n % mod * n % mod) % mod
        return (res * base % mod).toInt()
    }
}
