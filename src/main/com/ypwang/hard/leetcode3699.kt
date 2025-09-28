package com.ypwang.hard

class Solution3699 {
    private val mod = 1_000_000_007

    private fun increase(n: Int, m: Int): Int {
        var prev = LongArray(m + 1) { 1L }
        val curr = LongArray(m + 1)

        for (pos in 2..n) {
            val dir = if (pos % 2 == 0) 1 else -1
            val pref = LongArray(m + 1)

            for (i in 1..m)
                pref[i] = (pref[i - 1] + prev[i]) % mod

            if (dir == 1) {
                for (v in 1..m)
                    curr[v] = pref[v - 1]
            } else {
                for (v in 1..m)
                    curr[v] = (pref[m] - pref[v] + mod) % mod
            }

            prev = curr.copyOf()
            curr.fill(0L)
        }

        var total = 0L
        for (v in 1..m)
            total = (total + prev[v]) % mod

        return total.toInt()
    }

    fun zigZagArrays(n: Int, l: Int, r: Int): Int {
        val m = r - l + 1
        val ans = increase(n, m)
        return (2L * ans % mod).toInt()
    }
}
