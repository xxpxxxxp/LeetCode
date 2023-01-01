package com.ypwang.medium

class Solution2521 {
    private val ps = intArrayOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31)
    fun distinctPrimeFactors(nums: IntArray): Int {
        val primes = mutableSetOf<Int>()
        for (n in nums) {
            var nn = n
            for (p in ps) {
                if (nn % p == 0) {
                    primes.add(p)
                    while (nn % p == 0)
                        nn /= p
                }
            }
            if (nn != 1)
                primes.add(nn)
        }
        return primes.size
    }
}