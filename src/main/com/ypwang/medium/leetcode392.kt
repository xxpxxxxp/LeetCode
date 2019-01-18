package com.ypwang.medium

class Solution392 {
    fun isSubsequence(s: String, t: String): Boolean {
        var cur = 0
        for (c in s) {
            while (cur < t.length && t[cur] != c) {
                cur++
            }
            if (cur == t.length) {
                return false
            }
            cur++
        }
        return true
    }
}