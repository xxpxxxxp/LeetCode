package com.ypwang.medium

class Solution2575 {
    fun divisibilityArray(word: String, m: Int): IntArray {
        val rst = IntArray(word.length)
        var mod = 0L
        for ((i, c) in word.withIndex()) {
            mod = ((mod * 10) + (c - '0')) % m
            if (mod == 0L)
                rst[i] = 1
        }

        return rst
    }
}