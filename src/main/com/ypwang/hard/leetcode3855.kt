package com.ypwang.hard

class Solution3855 {
    var mod = 1000000007

    fun sumOfNumbers(l: Int, r: Int, k: Int): Int {
        val count = (r - l + 1).toLong()
        val sumRange = (l + r).toLong() * count / 2

        // Terms for the final product
        val t1 = sumRange % mod
        val t2 = power(count, (k - 1).toLong())

        // Geometric series sum: (10^k - 1) / 9
        val repunit = (power(10, k.toLong()) - 1 + mod) % mod
        val inv9 = power(9, (mod - 2).toLong()) // Modular inverse of 9
        val t3 = (repunit * inv9) % mod

        var ans = (t1 * t2) % mod
        ans = (ans * t3) % mod

        return ans.toInt()
    }

    fun power(base: Long, exp: Long): Long {
        var base = base
        var exp = exp
        var res = 1L
        base %= mod.toLong()
        while (exp > 0) {
            if (exp % 2 == 1L)
                res = (res * base) % mod
            base = (base * base) % mod
            exp /= 2
        }
        return res
    }
}
