package com.ypwang.hard

class Solution2565 {
    fun minimumScore(s: String, t: String): Int {
        val dp = IntArray(t.length) { -1 }
        var k = t.lastIndex
        for ((i, c) in s.withIndex().reversed()) {
            if (c == t[k])
                dp[k--] = i
            if (k < 0)
                break
        }
        var rst = k+1
        var i = 0
        var j = 0
        while (i < s.length && j < t.length && rst > 0) {
            if (s[i] == t[j]) {
                while (k < t.length && dp[k] <= i)
                    k++
                j++
                rst = minOf(rst, k - j)
            }
            i++
        }
        return rst
    }
}