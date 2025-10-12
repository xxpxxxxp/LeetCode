package com.ypwang.hard

class Solution3715 {
    private fun kernel(x: Long): Long {
        var x = x
        var res = 1L
        var p = 2L
        while (p * p <= x) {
            var odd = 0
            while (x % p == 0L) {
                x /= p
                odd = odd xor 1
            }
            if (odd == 1)
                res *= p
            p++
        }

        if (x > 1)
            res *= x
        return res
    }

    fun sumOfAncestors(n: Int, edges: Array<IntArray>, nums: IntArray): Long {
        val g = Array(n) { mutableListOf<Int>() }
        for ((a, b) in edges) {
            g[a].add(b)
            g[b].add(a)
        }

        val k = LongArray(n) { kernel(nums[it].toLong()) }
        val freq = mutableMapOf<Long, Int>()
        var rst = 0L

        fun dfs(u: Int, p: Int) {
            val ku = k[u]
            rst += freq.getOrDefault(ku, 0)
            freq[ku] = freq.getOrDefault(ku, 0) + 1

            for (v in g[u])
                if (v != p)
                    dfs(v, u)

            val left = freq[ku]!! - 1
            if (left == 0)
                freq.remove(ku)
            else
                freq[ku] = left
        }

        dfs(0, -1)
        return rst
    }
}
