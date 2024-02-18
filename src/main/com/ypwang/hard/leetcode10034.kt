package com.ypwang.hard

class Solution10034b {
    fun numberOfPowerfulInt(start: Long, finish: Long, limit: Int, s: String): Long {
        val cnt = LongArray(16)

        val hi = finish.toString()
        val lo = (start-1).toString()
        var pSum = 1L
        var comb = 1L

        for (size in s.length until hi.length) {
            if (size > s.length) {
                pSum += comb * limit
                comb *= (limit + 1)
            }
            cnt[size] = pSum
        }

        fun dfs(i: Int, limit: Char, n: String): Long {
            if (n.length < s.length)
                return 0L
            if (i == n.length - s.length)
                return if (n.substring(i) >= s) 1 else 0
            val digits = minOf(limit, n[i]) - '1' + if (i > 0) 1 else 0
            return cnt[n.length-i-1] * digits + if (n[i] < limit) dfs(i+1, limit, n) else 0
        }

        return cnt[hi.length-1] + dfs(0, '1' + limit, hi) - cnt[lo.length-1] - dfs(0, '1' + limit, lo)
    }
}