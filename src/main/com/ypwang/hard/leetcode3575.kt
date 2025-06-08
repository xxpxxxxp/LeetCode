package com.ypwang.hard

class Solution3575 {
    private val mod = 1_000_000_007
    private var ans = 0

    private fun check(n: Int, freq: Int): Boolean {
        var num = n
        var f = freq
        while (num > 0) {
            val x = num % 10
            if ((f shr x) and 1 == 1)
                return false

            f = f or (1 shl x)
            num /= 10
        }
        return true
    }

    private fun give(i: Int, nums: List<Int>, freq: Int, dp: Array<IntArray>): Int {
        if (i >= nums.size)
            return 0
        if (dp[i][freq] != -1)
            return dp[i][freq]

        val notTake = give(i + 1, nums, freq, dp)
        var take = 0
        if (check(nums[i], freq)) {
            var newFreq = freq
            var x = nums[i]
            while (x > 0) {
                val y = x % 10
                newFreq = newFreq or (1 shl y)
                x /= 10
            }
            take = nums[i] + give(i + 1, nums, newFreq, dp)
        }

        dp[i][freq] = maxOf(take, notTake)
        return dp[i][freq]
    }

    private fun dfs(node: Int, vals: IntArray, adj: Array<MutableList<Int>>): List<Int> {
        val toGive = mutableListOf<Int>()
        for (i in adj[node])
            toGive.addAll(dfs(i, vals, adj))

        toGive.add(vals[node])
        val dp = Array(toGive.size + 1) { IntArray(1025) { -1 } }
        val temp = give(0, toGive, 0, dp)
        ans = (ans + temp) % mod
        return toGive
    }

    fun goodSubtreeSum(vals: IntArray, par: IntArray): Int {
        val n = par.size
        val adj = Array(n) { mutableListOf<Int>() }
        for (i in 1 until n)
            adj[par[i]].add(i)

        dfs(0, vals, adj)
        return ans
    }
}
