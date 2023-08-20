package com.ypwang.medium

class Solution2825 {
    fun canMakeSubsequence(str1: String, str2: String): Boolean {
        var i = 0
        var j = 0
        val n = str1.length
        val m = str2.length

        while (i < n && j < m) {
            val a = str1[i]
            val b = str2[j]
            if (a == b || a + 1 == b || a - 25 == b)
                j++
            i++
        }
        return j == m
    }
}
