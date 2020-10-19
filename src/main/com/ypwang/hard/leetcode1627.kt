package com.ypwang.hard

class Solution1627 {
    fun areConnected(n: Int, threshold: Int, queries: Array<IntArray>): List<Boolean> {
        val dsu = IntArray(n){it}

        fun root(i: Int): Int {
            if (dsu[i] != i)
                dsu[i] = root(dsu[i])

            return dsu[i]
        }

        fun union(i: Int, j: Int) {
            val ri = root(i)
            val rj = root(j)
            dsu[ri] = rj
        }

        val sieve = ((threshold+1)..n).toList()
        val primes = BooleanArray(sieve.size) { true }
        var idx = 0
        while (idx < primes.size) {
            while (idx < primes.size && !primes[idx])
                idx++

            if (idx < primes.size) {
                val prime = sieve[idx]
                for (i in idx until sieve.size) {
                    if (sieve[i] % prime == 0) {
                        primes[i] = false
                        union(sieve[i]-1, prime-1)
                    }
                }
            }
        }

        return queries.map { (i, j) -> root(i-1) == root(j-1) }
    }
}