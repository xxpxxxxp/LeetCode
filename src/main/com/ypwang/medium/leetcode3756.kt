package com.ypwang.medium

class Solution3756 {
    fun sumAndMultiply(s: String, queries: Array<IntArray>): IntArray {
        val MOD = 1000000007L
        val n = s.length

        val idx = IntArray(n + 1) // prefix count of non-zero digits
        val `val` = LongArray(n + 1) // prefix concatenation (mod)
        val tot = LongArray(n + 1) // prefix digit sum
        val pow10 = LongArray(n + 1) // powers of 10

        pow10[0] = 1
        for (i in 1..n) pow10[i] = (pow10[i - 1] * 10) % MOD

        var c = 0

        // Build prefixes
        for (i in 0 until n) {
            val d = s[i] - '0'
            if (d != 0) {
                c++
                `val`[c] = (`val`[c - 1] * 10 + d) % MOD
                tot[c] = tot[c - 1] + d
            }
            idx[i + 1] = c
        }

        val m = queries.size
        val ans = IntArray(m)

        for (i in 0 until m) {
            val (l, r) = queries[i]

            val a = idx[l]
            val b = idx[r + 1]

            if (a == b) {
                ans[i] = 0
                continue
            }

            val len = b - a
            val num = (`val`[b] - (`val`[a] * pow10[len]) % MOD + MOD) % MOD
            val sumDigits = tot[b] - tot[a]

            ans[i] = ((num * sumDigits) % MOD).toInt()
        }

        return ans
    }
}
