package com.ypwang.medium

class Solution2523 {
    fun closestPrimes(left: Int, right: Int): IntArray {
        val isPrime = BooleanArray(right + 1) { true }
        isPrime[0] = false
        isPrime[1] = false

        var i = 2
        while (i * i <= right) {
            if (isPrime[i]) {
                var j = i * i
                while (j <= right) {
                    isPrime[j] = false
                    j += i
                }
            }
            i++
        }

        var min = Int.MAX_VALUE
        val primes = (left..right).filter { isPrime[it] }
        var res: IntArray = intArrayOf(-1, -1)
        for (i in 0 until primes.size - 1) {
            if (primes[i + 1] - primes[i] < min) {
                min = primes[i + 1] - primes[i]
                res = intArrayOf(primes[i], primes[i + 1])
            }
        }
        return res
    }
}