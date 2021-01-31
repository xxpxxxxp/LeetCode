package com.ypwang.hard

class Solution1745 {
    fun checkPartitioning(s: String): Boolean {
        // [i, j] inclusive
        val palindrome = Array(s.length) { BooleanArray(s.length) }
        for (len in s.indices) {
            for (i in 0 until s.length - len) {
                palindrome[i][i+len] =
                    when (len) {
                        0 -> true
                        1 -> s[i] == s[i+1]
                        else -> s[i] == s[i+len] && palindrome[i+1][i+len-1]
                    }
            }
        }

        for (i in 0 until s.length-2) {
            for (j in i+1 until s.length-1) {
                if (palindrome[0][i] && palindrome[i+1][j] && palindrome[j+1][s.lastIndex])
                    return true
            }
        }

        return false
    }
}