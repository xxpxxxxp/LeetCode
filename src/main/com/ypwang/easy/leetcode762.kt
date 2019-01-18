package com.ypwang.easy

class Solution762 {
    fun countPrimeSetBits(L: Int, R: Int): Int {
        val primes = setOf(2, 3, 5, 7, 11, 13, 17, 19)
        return (L..R).count{ it.toString(2).count{ it == '1' } in primes }
    }
}