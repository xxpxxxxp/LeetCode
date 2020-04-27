package com.ypwang.medium

class Solution1423 {
    fun maxScore(cardPoints: IntArray, k: Int): Int {
        var max = cardPoints.take(k).sum()
        var cur = max

        for (i in 0 until k) {
            cur -= cardPoints[k-i-1]
            cur += cardPoints[cardPoints.lastIndex-i]
            max = maxOf(max, cur)
        }

        return max
    }
}