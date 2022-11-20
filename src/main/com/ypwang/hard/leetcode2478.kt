package com.ypwang.hard

class Solution2478 {
    fun beautifulPartitions(s: String, k: Int, minLength: Int): Int {
        if (k * minLength > s.length || !isPrime(s[0]) || isPrime(s[s.length - 1]))
            return 0

        // dp[j][p] how many possible cut of p slice at idx j
        val dp = Array(s.length + 1) { IntArray(k + 1) }
        dp[0][0] = 1
        for (i in 0 until s.length - minLength + 1)
            // cut at i
            if (isPrime(s[i]) && (i == 0 || !isPrime(s[i - 1])))
                for (j in i + minLength - 1 until s.length)
                    if (!isPrime(s[j]))
                        for (p in 0 until k)
                            dp[j+1][p+1] = (dp[j+1][p+1] + dp[i][p]) % 1000000007
        return dp[s.length][k]
    }

    private fun isPrime(c: Char): Boolean = c in setOf('2', '3', '5', '7')
}