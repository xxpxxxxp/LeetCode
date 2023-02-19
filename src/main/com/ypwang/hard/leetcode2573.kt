package com.ypwang.hard

class Solution2573 {
    fun findTheString(lcp: Array<IntArray>): String {
        val n = lcp.size

        // potential answer
        val arr = CharArray(n)
        arr[0] = 'a'
        for (i in 1 until n) {
            var test = 'a'
            var found = false
            for (j in 0 until i) {
                test = maxOf(test, arr[j])
                if (lcp[i][j] != 0) {
                    found = true
                    arr[i] = arr[j]
                    break
                }
            }
            if (found)
                continue
            ++test
            arr[i] = test

            // More than 26 characters needed.
            if (test > 'z')
                return ""
        }

        // lcp from potential string
        val dp = Array(n + 1) { IntArray(n + 1) }
        for (i in n - 1 downTo 0) {
            for (j in n - 1 downTo 0) {
                dp[i][j] = if (arr[i] != arr[j]) 0 else 1 + dp[i + 1][j + 1]
            }
        }

        // compare dp and lcp as both should be same
        for (i in n - 1 downTo 0) {
            for (j in n - 1 downTo 0) {
                if (dp[i][j] != lcp[i][j]) return ""
            }
        }
        return String(arr)
    }
}