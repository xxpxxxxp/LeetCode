package com.ypwang.hard

class Solution4009 {
    fun minMaxWaitingTime(demand: IntArray, fuel: IntArray): Int {
        val memo = mutableMapOf<String, IntArray>()

        fun dfs(i: Int, f0: Int, f1: Int, w0: Int, w1: Int): IntArray {
            var res0 = 0
            var res1 = 0
            var c0 = 0
            var c1 = 0
            val n = demand.size
            if (i == n)
                return intArrayOf(0, 0)

            val state = "$i,$f0,$f1,$w0,$w1"
            if (state in memo)
                return memo[state]!!

            val d = demand[i]
            if (f0 >= d) {
                val p = dfs(i + 1, f0 - d, f1, d, maxOf(0, w1 - w0))
                c0 = p[0] + 1
                res0 = maxOf(p[1], w0)
            }
            if (f1 >= d) {
                val p = dfs(i + 1, f0, f1 - d, maxOf(0, w0 - w1), d)
                c1 = p[0] + 1
                res1 = maxOf(p[1], w1)
            }

            val ans =
            if (c0 < c1)
                intArrayOf(c1, res1)
            else if (c0 > c1)
                intArrayOf(c0, res0)
            else
                intArrayOf(c0, minOf(res0, res1))

            memo[state] = ans
            return ans
        }

        val p = dfs(0, fuel[0], fuel[1], 0, 0)
        return if (p[0] > 0) p[1] else -1
    }
}
