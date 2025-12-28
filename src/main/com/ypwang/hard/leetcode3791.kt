package com.ypwang.hard

class Solution3791 {
    val OFFSET: Int = 100

    fun dp(memo: Array<Array<LongArray>>, idx: Int, bal: Int, tight: Int, total: Int, constraint: String): Long {
        if (bal !in 0 until 200)
            return 0
        if (idx == total)
            return if (bal == OFFSET) 1L else 0L
        if (idx >= 25)
            return 0

        if (memo[idx][bal][tight] != -1L)
            return memo[idx][bal][tight]

        var ans = 0L
        val limit = if (tight == 1) (constraint[idx] - '0') else 9

        for (d in 0..limit) {
            val nextTight = if (tight == 1 && d == limit) 1 else 0
            val nextBal = bal + (if (idx % 2 == 0) d else -d)
            ans += dp(memo, idx + 1, nextBal, nextTight, total, constraint)
        }

        return ans.also { memo[idx][bal][tight] = it }
    }

    fun solve(n: Long): Long {
        if (n < 10)
            return 0

        val num = n.toString()
        val len = num.length
        var total = 0L

        // Smaller lengths
        for (l in 2 until len)
            for (d in 1..9)
                total += dp(Array(20) { Array(200) { LongArray(2) { -1 } } }, 1, OFFSET + d, 0, l, "9".repeat(l))

        val first = num[0] - '0'
        for (d in 1..first)
            total += dp(Array(20) { Array(200) { LongArray(2) { -1 } } }, 1, OFFSET + d, if (d == first) 1 else 0, len, num)

        return total
    }

    fun countBalanced(low: Long, high: Long): Long =
        solve(high) - solve(low - 1)
}
