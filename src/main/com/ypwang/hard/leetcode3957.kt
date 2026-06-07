package com.ypwang.hard

class Solution3957 {
    fun maximumSum(nums: IntArray, m: Int, l: Int, r: Int): Long {
        val n = nums.size

        val NEG = Long.MIN_VALUE

        val dp = Array(m + 1) { LongArray(n + 1) { NEG } }
        val pref = LongArray(n + 1)

        for (i in 0 until n)
            pref[i + 1] = pref[i] + nums[i]

        for (i in 0..n)
            dp[0][i] = 0L

        var ans = Long.MIN_VALUE

        for (k in 1..m) {
            dp[k][n] = 0L
            val dq = ArrayDeque<Int>()

            for (i in n - 1 downTo 0) {
                if (i + l <= n) {
                    val curr = pref[i + l] + dp[k - 1][i + l]

                    while (dq.isNotEmpty()) {
                        val b = dq.last()
                        val value = pref[b] + dp[k - 1][b]

                        if (value >= curr)
                            break
                        dq.removeLast()
                    }

                    dq.addLast(i + l)
                }

                while (dq.isNotEmpty() && dq.first() > i + r)
                    dq.removeFirst()

                dp[k][i] = dp[k][i + 1]

                if (dq.isNotEmpty()) {
                    val j = dq.first()
                    dp[k][i] = maxOf(
                        dp[k][i],
                        dp[k - 1][j] + pref[j] - pref[i]
                    )
                }
            }

            ans = maxOf(ans, dp[k][0])
        }

        if (ans == 0L) {
            var best = Long.MIN_VALUE

            for (i in 0 until n) {
                var len = l
                while (len <= r && i + len <= n) {
                    best = maxOf(best, pref[i + len] - pref[i])
                    len++
                }
            }

            return best
        }

        return ans
    }
}
