package com.ypwang.hard

class Solution2262 {
    fun appealSum(s: String): Long {
        var res = 0L
        var cur = 0L
        val prev = IntArray(26)
        for ((i, c) in s.withIndex()) {
            cur += i + 1 - prev[c - 'a']
            prev[c - 'a'] = i + 1
            res += cur
        }
        return res
    }
}