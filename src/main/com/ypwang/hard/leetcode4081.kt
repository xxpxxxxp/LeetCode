package com.ypwang.hard

class Solution4081 {
    fun maxPrimeSubset(n: Int, s: Int): List<Int> {
        if (n < 2 || s < 2)
            return listOf()

        val lim = minOf(n, s)
        val isPrime = BooleanArray(lim + 1) { true }

        var x = 2
        while (x * x <= lim) {
            if (isPrime[x]) {
                var i = x * x
                while (i <= lim) {
                    isPrime[i] = false
                    i += x
                }
            }
            ++x
        }

        val primesList = mutableListOf<Int>()
        for (x in 2..lim)
            if (isPrime[x])
                primesList.add(x)

        if (primesList.isEmpty())
            return listOf()

        val m = primesList.size
        val primes = primesList.toIntArray()
        val INF = 100000
        val dp = Array(m + 1) { IntArray(s + 1) { INF } }
        dp[m][0] = 0

        for (i in m - 1 downTo 0) {
            val p = primes[i]
            for (v in 0..s) {
                dp[i][v] = dp[i + 1][v]
                if (v >= p && dp[i + 1][v - p] != INF)
                    dp[i][v] = minOf(dp[i][v], dp[i + 1][v - p] + 1)
            }
        }

        var bestSum = -1
        for (v in s downTo 1) {
            if (dp[0][v] != INF) {
                bestSum = v
                break
            }
        }

        if (bestSum == -1)
            return listOf()

        var c = dp[0][bestSum]
        var v = bestSum
        var i = 0
        val res = mutableListOf<Int>()

        while (v > 0) {
            for (j in i until m) {
                val p = primes[j]
                if (p > v)
                    break
                if (dp[j + 1][v - p] == c - 1) {
                    res.add(p)
                    v -= p
                    c--
                    i = j + 1
                    break
                }
            }
        }

        return res
    }
}
