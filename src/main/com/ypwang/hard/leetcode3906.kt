package com.ypwang.hard

class Solution3906 {
    private val memo = Array(17) { Array(11) { LongArray(2) } }
    private val onPath = BooleanArray(16)
    private var s: String? = null

    private fun dp(i: Int, v: Int, t: Int): Long {
        if (i == 16)
            return 1
        if (memo[i][v][t] != -1L)
            return memo[i][v][t]
        var res = 0L
        val lim = if (t > 0) (s!![i] - '0') else 9
        for (x in 0..lim) {
            if (onPath[i]) {
                if (x >= v)
                    res += dp(i + 1, x, if (x == lim) t else 0)
            } else {
                res += dp(i + 1, v, if (x == lim) t else 0)
            }
        }
        return res.also { memo[i][v][t] = it }
    }

    private fun f(n: Long): Long {
        if (n < 0)
            return 0
        s = String.format("%016d", n)
        for (i in 0..16)
            for (j in 0..10)
                memo[i][j].fill(-1)

        return dp(0, 0, 1)
    }

    fun countGoodIntegersOnPath(l: Long, r: Long, directions: String): Long {
        var i = 0
        onPath[0] = true
        for (d in directions.toCharArray()) {
            i += if (d == 'D') 4 else 1
            onPath[i] = true
        }
        return f(r) - f(l - 1)
    }
}
