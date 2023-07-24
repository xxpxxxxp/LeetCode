package com.ypwang.hard

class Solution2791 {
    fun countPalindromePaths(parent: List<Int>, s: String): Long {
        val n = parent.size
        val dp = IntArray(n)
        var res = 0L
        val count = mutableMapOf<Int, Int>()

        fun f(dp: IntArray, i: Int): Int {
            if (i > 0 && dp[i] == 0)
                dp[i] = f(dp, parent[i]) xor (1 shl s[i] - 'a')
            return dp[i]
        }

        for (i in 0 until n) {
            val mask = f(dp, i)
            val v = count.getOrDefault(mask, 0)
            for (j in 0..25)
                res += count.getOrDefault(mask xor (1 shl j), 0).toLong()
            res += v.toLong()
            count[mask] = v + 1
        }
        return res
    }
}