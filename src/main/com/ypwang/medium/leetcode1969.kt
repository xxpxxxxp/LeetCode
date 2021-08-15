package com.ypwang.medium

import java.math.BigInteger

class Solution1969 {
    fun minNonZeroProduct(p: Int): Int {
        val one = BigInteger.valueOf(1)
        val two = BigInteger.valueOf(2)
        val mod = BigInteger.valueOf(1000000007)

        return two.pow(p).minus(two).modPow(
            two.pow(p-1).minus(one),
            mod
        ).multiply(
            two.pow(p).minus(one)
        ).mod(mod).toInt()
    }
}
