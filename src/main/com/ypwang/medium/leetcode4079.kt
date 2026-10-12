package com.ypwang.medium

class Solution4079 {
    fun maxPrimes(n: Int, s: Int): List<Int> {
        val isPrime = BooleanArray(n + 1) { true }
        isPrime[0] = false

        if (n >= 1)
            isPrime[1] = false

        var i = 2
        while (i * i <= n) {
            if (isPrime[i]) {
                var j = i * i
                while (j <= n) {
                    isPrime[j] = false
                    j += i
                }
            }
            i++
        }

        val ans = mutableListOf<Int>()
        var sum = 0

        for (i in 2..n) {
            if (isPrime[i] && sum + i <= s) {
                ans.add(i)
                sum += i
            }
        }

        return ans
    }
}
