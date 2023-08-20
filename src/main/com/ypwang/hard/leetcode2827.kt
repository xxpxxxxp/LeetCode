package com.ypwang.hard

class Solution2827 {
    fun numberOfBeautifulIntegers(low: Int, high: Int, k: Int): Int {
        fun Boolean.toInt(): Int = if (this) 1 else 0

        fun helper(dp: Array<Array<Array<Array<Array<IntArray>>>>>, s: String, tight: Boolean, pos: Int, odd: Int, even: Int, sum: Int, zero: Boolean): Int {
            if (pos == s.length)
                return if (!zero && sum == 0 && odd == even) 1 else 0

            if (dp[tight.toInt()][pos][odd][even][sum][zero.toInt()] == -1) {
                val end = if (tight) s[pos] - '0' else 9
                var rst = if (zero) helper(dp, s, false, pos + 1, odd, even, sum, zero) else 0
                for (i in 0..end) {
                    val newTight = tight && i == (s[pos] - '0')
                    val newOdd = odd + (i % 2)
                    val newEven = even + if ((!zero || i > 0) && i % 2 == 0) 1 else 0

                    if (zero && i != 0)
                        rst += helper(dp, s, newTight, pos + 1, newOdd, newEven, i, false)
                    else if (!zero)
                        rst += helper(dp, s, newTight, pos + 1, newOdd, newEven, (sum * 10 + i) % k, false)
                }

                dp[tight.toInt()][pos][odd][even][sum][zero.toInt()] = rst
            }
            return dp[tight.toInt()][pos][odd][even][sum][zero.toInt()]
        }

        var dp =
            Array(2) {
                Array(12) {
                    Array(12) {
                        Array(12) {
                            Array(20) {
                                IntArray(2) { -1 }
                            }
                        }
                    }
                }
            }
        val max = helper(dp, high.toString(), true, 0, 0, 0, 0, true)

        dp =
            Array(2) {
                Array(12) {
                    Array(12) {
                        Array(12) {
                            Array(20) {
                                IntArray(2) { -1 }
                            }
                        }
                    }
                }
            }
        val min = helper(dp, (low-1).toString(), true, 0, 0, 0, 0, true)
        return max - min
    }
}
