package com.ypwang.hard

class Solution3116 {
    private fun lcm(a: Long, b: Long): Long =
        a * b / gcd(a, b)

    private fun gcd(a: Long, b: Long): Long =
        if (b == 0L) a else gcd(b, a % b)

    private fun pie(coins: IntArray, x: Long): Long {
        val m = coins.size
        val nn = 1 shl m
        var cnt = 0L
        for (i in 1 until nn) {
            var lcmm = 1L
            for (j in 0 until m)
                if ((i and (1 shl j)) != 0)
                    lcmm = lcm(lcmm, coins[j].toLong())
            cnt += if (Integer.bitCount(i) % 2 == 1) x / lcmm else -x / lcmm
        }
        return cnt
    }

    fun findKthSmallest(coins: IntArray, k: Int): Long {
        val kk = k.toLong()
        var l = 1L
        var r = 1e11.toLong()
        while (l < r) {
            val m = (l + r) / 2
            val cnt = pie(coins, m)
            if (cnt < kk)
                l = m + 1
            else
                r = m
        }
        return l
    }
}
