package com.ypwang.hard

class Solution1595 {
    fun connectTwoGroups(cost: List<List<Int>>): Int {
        val m = cost.size
        val n = cost[0].size

        val minY = (0 until n).map { j -> (0 until m).map { i -> cost[i][j] }.minOrNull()!! }.toTypedArray()

        val dp = Array(m+1) { IntArray(4096){ -1 } }

        fun search(i: Int, mask: Int): Int {
            if (dp[i][mask] < 0) {
                dp[i][mask] =
                        if (i == m)
                            (0 until n).filter { mask and (1 shl it) == 0 }.map { minY[it] }.sum()
                        else {
                            var rst = Int.MAX_VALUE
                            for (j in 0 until n) {
                                rst = minOf(rst, cost[i][j] + search(i+1, mask or (1 shl j)))
                            }

                            rst
                        }
            }

            return dp[i][mask]
        }

        return search(0, 0)
    }
}