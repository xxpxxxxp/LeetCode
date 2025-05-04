package com.ypwang.hard

class Solution3539 {
    fun magicalSum(M: Int, K: Int, nums: IntArray): Int {
        val MOD = 1000000007
        val n = nums.size

        val f = LongArray(M + 1)
        val inverse_f = LongArray(M + 1)
        f[0] = 1
        for (i in 1..M)
            f[i] = f[i - 1] * i % MOD

        inverse_f[M] = modPow(f[M], (MOD - 2).toLong(), MOD)
        for (i in M downTo 1)
            inverse_f[i - 1] = inverse_f[i] * i % MOD

        val pow_nums = Array(n) { LongArray(M + 1) }
        for (i in 0..<n) {
            pow_nums[i][0] = 1
            for (c in 1..M) {
                pow_nums[i][c] = pow_nums[i][c - 1] * nums[i] % MOD
            }
        }

        val dp = Array(n + 1) {
            Array(M + 1) {
                Array(K + 1) {
                    LongArray(M + 1)
                }
            }
        }
        dp[0][0][0][0] = 1
        for (i in 0..<n) {
            for (m1 in 0..M) {
                for (k1 in 0..K) {
                    for (m2 in 0..M) {
                        val `val` = dp[i][m1][k1][m2]
                        if (`val` == 0L) continue
                        for (c in 0..M - m1) {
                            val m12 = m1 + c
                            val s = c + m2
                            val bit = s and 1
                            val k2 = k1 + bit
                            if (k2 > K) continue
                            val m22 = s shr 1
                            dp[i + 1][m12][k2][m22] =
                                (dp[i + 1][m12][k2][m22] + `val` * inverse_f[c] % MOD * pow_nums[i][c] % MOD) % MOD
                        }
                    }
                }
            }
        }

        var ans: Long = 0
        for (k1 in 0..K) {
            for (m2 in 0..M) {
                val `val` = dp[n][M][k1][m2]
                if (`val` == 0L) continue
                val bits = Integer.bitCount(m2)
                if (k1 + bits == K) {
                    ans = (ans + `val`) % MOD
                }
            }
        }

        ans = ans * f[M] % MOD
        return ans.toInt()
    }

    private fun modPow(a: Long, e: Long, mod: Int): Long {
        var a = a
        var e = e
        var res: Long = 1
        while (e > 0) {
            if ((e and 1L) != 0L) res = res * a % mod
            a = a * a % mod
            e = e shr 1
        }
        return res
    }
}
