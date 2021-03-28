package com.ypwang.hard

class Solution1808 {
    private val mod = 1000000007

    private fun modPow(pow: Int): Long =
        3.toBigInteger().modPow(pow.toBigInteger(), mod.toBigInteger()).toLong()

    fun maxNiceDivisors(primeFactors: Int): Int =
        if (primeFactors <= 3)
            primeFactors
        else {
            (when (primeFactors % 3) {
                1 -> modPow((primeFactors - 4) / 3) * 4
                2 -> modPow((primeFactors - 2) / 3) * 2
                else -> modPow(primeFactors / 3)
            } % mod).toInt()
        }
}