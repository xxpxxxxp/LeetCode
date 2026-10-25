package com.ypwang.easy

class Solution4092 {
    fun calculateScore(a: Int, b: Int): Int {
        val scoreA = Integer.bitCount(a)
        val scoreB = Integer.bitCount(b)
        return if (scoreA >= scoreB)
            scoreA * scoreB
        else
            scoreB / scoreA
    }
}
