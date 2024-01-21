package com.ypwang.easy

class Solution3014 {
    fun minimumPushes(word: String): Int {
        val l = word.length
        val n = l / 8
        return 8 * n * (n+1) / 2 + l % 8 * (n+1)
    }
}