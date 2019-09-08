package com.ypwang.easy

class Solution1180 {
    fun countLetters(S: String): Int {
        var cur = S[0]
        var len = 1
        var sum = 1
        for (i in 1 until S.length) {
            if (S[i] == cur) {
                len++
            } else {
                cur = S[i]
                len = 1
            }
            sum += len
        }

        return sum
    }
}