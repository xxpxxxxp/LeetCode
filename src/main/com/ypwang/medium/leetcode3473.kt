package com.ypwang.medium

class Solution3473 {
    fun maxSum(nums: IntArray, k: Int, m: Int): Int {
        val n = nums.size
        val dp = Array(2) { Array(k + 1) { IntArray(n) { -1 } } }

        fun solve(i: Int, k: Int, m: Int, started: Int, arr: IntArray): Int {
            if (k == 0)
                return 0
            if (i == arr.size) {
                if (k == 1 && started == 1)
                    return 0
                return -20000000
            }
            if (dp[started][k][i] == -1) {
                var a = -20000000
                var b = -20000000
                var c = -20000000
                var d = -20000000
                var e = -20000000

                if (started == 1) {
                    a = arr[i] + solve(i + 1, k, m, 1, arr)
                    b = solve(i + 1, k - 1, m, 0, arr)
                    if (i + m - 1 < arr.size) {
                        var sum = 0
                        for (j in i until i + m)
                            sum += arr[j]
                        c = sum + solve(i + m, k - 1, m, 1, arr)
                    }
                } else {
                    if (i + m - 1 < arr.size) {
                        var sum = 0
                        for (j in i until i + m)
                            sum += arr[j]
                        d = sum + solve(i + m, k, m, 1, arr)
                    }
                    e = solve(i + 1, k, m, started, arr)
                }
                dp[started][k][i] = maxOf(a, b, c, d, e)
            }
            return dp[started][k][i]
        }

        return solve(0, k, m, 0, nums)
    }
}
