package com.ypwang.hard

class Solution3797 {
    fun numberOfRoutes(grid: Array<String>, d: Int): Int {
        val n = grid.size
        val m = grid[0].length
        val mod: Long = 1000000007

        var dp: LongArray? = null
        for (i in n - 1 downTo 0) {
            val r = grid[i]
            if (dp == null) {
                val init = LongArray(m) { 1 }
                dp = f(init, 0, r, m, mod)
            } else {
                val d2 = Math.sqrt((d * d - 1).toDouble()).toInt()
                dp = f(dp, d2, r, m, mod)
            }
            dp = f(dp, d, r, m, mod)
        }

        return dp!!.fold(0L) { a, b -> (a + b) % mod }.toInt()
    }

    private fun f(dp: LongArray, dist: Int, r: String, m: Int, mod: Long): LongArray {
        val dp2 = LongArray(m)
        var window = 0L
        for (k in 0..minOf(m - 1, dist))
            window += dp[k]
        dp2[0] = window
        for (j in 1 until m) {
            window = dp2[j - 1]
            if (j - dist - 1 >= 0)
                window -= dp[j - dist - 1]
            if (j + dist < m)
                window += dp[j + dist]
            dp2[j] = window
        }
        for (j in 0 until m)
            dp2[j] = if (r[j] == '#') 0 else dp2[j] % mod
        return dp2
    }
}
