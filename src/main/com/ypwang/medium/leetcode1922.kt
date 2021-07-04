package com.ypwang.medium

import java.math.BigInteger

class Solution1922 {
    fun countGoodNumbers(n: Long): Int {
        val mod = BigInteger.valueOf(1000000007)
        val odd = n / 2
        val even = (n + 1) / 2

        return (BigInteger.valueOf(4).modPow(BigInteger.valueOf(odd), mod) *
                BigInteger.valueOf(5).modPow(BigInteger.valueOf(even), mod)).mod(mod)
            .toInt()
    }
}