package com.ypwang.medium

class Solution2712 {
    fun minimumCost(s: String): Long {
        var res = 0L
        var i = 1
        val n = s.length
        while (i < n) {
            if (s[i] != s[i - 1])
                res += minOf(i, n - i)
            ++i
        }
        return res
    }
}