package com.ypwang.hard

class Solution3966 {
    fun goodIntegers(l: Long, r: Long, k: Int): Long {
        fun get(s: String, n: Int, i: Int, prev: Int, small: Boolean, dp: Array<Array<LongArray>>): Long {
            if (i == n)
                return 1

            val smallIdx = if (small) 1 else 0
            if (dp[i][prev][smallIdx] != -1L)
                return dp[i][prev][smallIdx]

            var res = 0L
            val start = maxOf(0, prev - k)
            var end = minOf(9, prev + k)
            if (!small)
                end = minOf(end, s[i] - '0')

            for (j in start..end)
                res += get(s, n, i + 1, j, small || (j < (s[i] - '0')), dp)

            return res.also { dp[i]!![prev]!![smallIdx] = it }
        }

        fun f(num: Long, k: Long): Long {
            val dp = Array(16) { Array(10) { LongArray(2) { -1L } } }

            val s = num.toString()
            val n = s.length
            var res = 0L
            for (len in 0 until n) {
                val mx = (if (len == 0) s[0] - '0' else 9)
                for (prev in 1..mx) {
                    res += if (len == 0 && prev == mx)
                        get(s, n, 1, prev, false, dp)
                    else
                        get(s, n, len + 1, prev, true, dp)
                }
            }
            return res
        }

        return f(r, k.toLong()) - f(l - 1, k.toLong())
    }
}
