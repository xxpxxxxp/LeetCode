package com.ypwang.hard

class Solution3621 {
    fun popcountDepth(n: Long, k: Int): Long {
        if (k == 0)
            return if (n >= 1) 1L else 0L

        val j = IntArray(64) { -1 }
        val l = mutableSetOf<Int>()
        for (m in 1..63)
            if (depth(m, j) == k - 1)
                l.add(m)

        if (l.isEmpty())
            return 0

        val s = n.toString(2)
        val i= Array(s.length + 1) { Array(s.length + 2) { LongArray(2) { -1 } } }

        val r = solution(0, 0, false, s, l, i)
        if (k == 1)
            return r - 1

        return r
    }

    private fun depth(n: Int, j: IntArray): Int {
        if (n == 1)
            return 0

        if (j[n] != -1)
            return j[n]

        val m = Integer.bitCount(n)
        j[n] = 1 + depth(m, j)
        return j[n]
    }

    private fun solution(
        idx: Int,
        bitCount: Int,
        notTight: Boolean,
        s: String,
        popCounts: Set<Int>,
        dp: Array<Array<LongArray>>
    ): Long {
        if (idx == s.length)
            return if (bitCount in popCounts) 1L else 0L

        val d = if (notTight) 1 else 0
        if (dp[idx][bitCount][d] != -1L)
            return dp[idx][bitCount][d]

        var e = 0L
        val f = if (notTight) 1 else (s[idx] - '0')
        for (g in 0..f) {
            val h = notTight || (g < f)
            e += solution(idx + 1, bitCount + g, h, s, popCounts, dp)
        }

        dp[idx][bitCount][d] = e
        return e
    }
}
