package com.ypwang.hard

class Solution3287 {
    fun allPossibleORsTillAnIndex(nums: IntArray, k: Int): Array<Array<IntArray>> {
        val n = nums.size
        val dp = Array(n) { Array(k + 1) { IntArray(129) { 0 } } }

        dp[0][1][nums[0]] = 1
        dp[0][0][0] = 1

        for (i in 1 until n) {
            dp[i][0][0] = 1
            for (j in 1..k) {
                for (x in 0..128) {
                    if (dp[i][j][x] == 0)
                        dp[i][j][x] = dp[i - 1][j][x]

                    val next = nums[i] or x
                    if (dp[i - 1][j - 1][x] != 0)
                        dp[i][j][next] = dp[i - 1][j - 1][x]
                }
            }
        }

        return dp
    }

    fun maxValue(nums: IntArray, k: Int): Int {
        val left = allPossibleORsTillAnIndex(nums, k)
        val right = allPossibleORsTillAnIndex(nums.reversed().toIntArray(), k).reversed()

        val n = nums.size
        var rst = 0

        for (i in k - 1 until n - k)
            for (a in 0..128)
                for (b in 0..128)
                    if (left[i][k][a] != 0 && right[i + 1][k][b] != 0)
                        rst = maxOf(rst, a xor b)

        return rst
    }
}
