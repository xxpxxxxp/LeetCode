package com.ypwang.hard

class Solution3704 {
    fun countNoZeroPairs(n: Long): Long {
        val s = n.toString()
        val a = IntArray(s.length) { s[s.length - 1 - it] - '0' }
        val dp = Array(17) { Array(2) { Array(2) { Array(2) { LongArray(2) { -1 } } } } }

        fun solve(i: Int, carry: Int, done1: Int, done2: Int, started: Int): Long {
            if (i == s.length)
                return (if (carry == 0 && started == 1) 1 else 0).toLong()

            if (dp[i][carry][done1][done2][started] != -1L)
                return dp[i][carry][done1][done2][started]
            if (done1 == 1 && done2 == 1)
                return 0

            var ans = 0L
            if (a[i] == carry)
                ans += solve(i + 1, 0, 1, 1, started)

            if (done1 == 1) {
                for (jj in 1..9) {
                    var curr = jj + carry
                    val newCarry = curr / 10
                    curr %= 10
                    if (curr == a[i]) {
                        ans += solve(i + 1, newCarry, done1, done2, 1)
                    }
                }
            }

            if (done2 == 1) {
                for (ii in 1..9) {
                    var curr = ii + carry
                    val newCarry = curr / 10
                    curr %= 10
                    if (curr == a[i]) {
                        ans += solve(i + 1, newCarry, done1, done2, 1)
                    }
                }
            }

            if (done1 == 0 && done2 == 0) {
                for (ii in 1..9) {
                    for (jj in 1..9) {
                        var curr = ii + jj + carry
                        val newCarry = curr / 10
                        curr %= 10
                        if (curr == a[i]) {
                            ans += solve(i + 1, newCarry, 1, done2, 0)
                            ans += solve(i + 1, newCarry, done1, 1, 0)
                            ans += solve(i + 1, newCarry, done1, done2, started)
                        }
                    }
                }
            }

            dp[i][carry][done1][done2][started] = ans
            return ans
        }
        
        return solve(0, 0, 0, 0, 1)
    }
}
