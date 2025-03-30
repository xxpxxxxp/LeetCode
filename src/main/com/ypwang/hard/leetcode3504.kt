package com.ypwang.hard

class Solution3504 {
    private var max = 0

    fun longestPalindrome(s: String, t: String): Int {
        val s2 = t.reversed()

        val n = s.length
        val m = s2.length

        val palin1 = palinDp(s)
        val palin2 = palinDp(s2)

        val dp1 = getDp(s, palin1)
        val dp2 = getDp(s2, palin2)

        val dp = Array(n + 1) { IntArray(m + 1) }
        for (i in 1..n) {
            for (j in 1..m) {
                if (s[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1
                    var next = 0
                    if (i < n) {
                        next = dp1[i]
                    }
                    if (j < m) {
                        next = maxOf(next, dp2[j])
                    }
                    max = maxOf(max, (2 * dp[i][j]) + next)
                } else {
                    dp[i][j] = 0
                }
            }
        }
        return max
    }

    private fun getDp(s: String, palin: Array<BooleanArray>): IntArray {
        val n = s.length
        val dp = IntArray(n) { 1 }
        for (i in 0 until n) {
            var len = 1
            for (j in i + 1 until n) {
                if (palin[i][j]) {
                    len = maxOf(len, j - i + 1)
                }
            }
            dp[i] = len
            max = maxOf(max, len)
        }
        return dp
    }

    private fun palinDp(s: String): Array<BooleanArray> {
        val n = s.length
        val isPalindrome = Array(n) { BooleanArray(n) }
        for (i in 0 until n) {
            isPalindrome[i][i] = true
            if (i < n - 1) {
                if (s[i] == s[i + 1]) {
                    isPalindrome[i][i + 1] = true
                }
            }
        }
        for (k in 3..n) {
            for (i in 0..n - k) {
                if (isPalindrome[i + 1][i + k - 2] && s[i] == s[i + k - 1]) {
                    isPalindrome[i][i + k - 1] = true
                }
            }
        }
        return isPalindrome
    }
}
