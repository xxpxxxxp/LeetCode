package com.ypwang.hard

class Solution3869 {
    fun countFancy(l: Long, r: Long): Long {
        val left = (l - 1).toString()
        val right = r.toString()

        return solve(0, -1, 0, 1, 0, 0, right, Array(right.length) {Array(11) {Array(4) {Array(2) {Array(2) {arrayOfNulls(200)}}}}}) -
                solve(0, -1, 0, 1, 0, 0, left, Array(left.length) {Array(11) {Array(4) {Array(2) {Array(2) {arrayOfNulls(200)}}}}})
    }

    fun solve(
        i: Int,
        prev: Int,
        dir: Int,
        tight: Int,
        lz: Int,
        sum: Int,
        s: String,
        dp: Array<Array<Array<Array<Array<Array<Long?>>>>>>
    ): Long {
        if (i == s.length) {
            if (lz == 0)
                return 0
            if (dir == 1 || dir == 2 || dir == 0)
                return 1
            if (isgood(sum))
                return 1
            return 0
        }

        val li = prev + 1
        if (dp[i][li][dir][tight][lz][sum] != null)
            return dp[i][li][dir][tight][lz][sum]!!

        val ub = if (tight == 1) s[i] - '0' else 9
        var ans = 0L
        for (d in 0..ub) {
            val nt = if (tight == 1 && d == ub) 1 else 0
            if (lz == 0 && d == 0) {
                ans += solve(i + 1, -1, 0, nt, 0, sum, s, dp)
                continue
            } else {
                val ns = sum + d
                if (lz == 0) {
                    ans += solve(i + 1, d, 0, nt, 1, ns, s, dp)
                    continue
                }
                val nd  = if (dir == 3) {
                    3
                } else if (dir == 0) {
                    if (d > prev) 1
                    else if (d < prev) 2
                    else 3
                } else if (dir == 1) {
                    if (d > prev) 1 else 3
                } else {
                    if (d < prev) 2 else 3
                }

                ans += solve(i + 1, d, nd, nt, 1, ns, s, dp)
            }
        }
        return ans.also { dp[i][li][dir][tight][lz][sum] = it }
    }

    fun isgood(sum: Int): Boolean {
        val s = sum.toString()

        if (s.length == 1)
            return true

        var inc = true
        var dec = true

        for (i in 1..<s.length) {
            if (s[i] <= s[i - 1])
                inc = false
            if (s[i] >= s[i - 1])
                dec = false
        }

        return inc || dec
    }
}
