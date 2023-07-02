package com.ypwang.medium

class Solution2761 {
    fun findPrimePairs(n: Int): List<List<Int>> {
        val primes = BooleanArray(n+1) { true }
        primes[0] = false
        primes[1] = false

        var p = 2
        while (p * p <= n) {
            if (primes[p]) {
                for (j in p * p..n step p)
                    primes[j] = false
            }
            p++
        }

        return (2 .. n/2).filter { primes[it] && primes[n - it] }.map { listOf(it, n - it) }
    }
}