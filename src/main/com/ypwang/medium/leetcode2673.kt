package com.ypwang.medium

class Solution2673 {
    fun minIncrements(n: Int, cost: IntArray): Int {
        var res = 0
        fun dfs(i: Int): Int {
            if (i >= cost.size)
                return 0
            val a = dfs(2 * i + 1)
            val b = dfs(2 * i + 2)
            res += Math.abs(a - b)
            return cost[i] + maxOf(a, b)
        }
        dfs(0)
        return res
    }
}