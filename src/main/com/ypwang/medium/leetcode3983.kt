package com.ypwang.medium

class Solution3983 {
    fun canMakeSubsequence(s: String, t: String): Boolean {
        var i = 0
        var j = 0
        val n = s.length
        for (c in t) {
            j = maxOf(j + (if (j < n && c == s[j]) 1 else 0), i + 1)
            i += (if (i < n && c == s[i]) 1 else 0)
        }

        return j >= n
    }
}
