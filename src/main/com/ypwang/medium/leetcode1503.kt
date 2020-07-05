package com.ypwang.medium

class Solution1503 {
    fun getLastMoment(n: Int, left: IntArray, right: IntArray): Int {
        return maxOf(
                left.max() ?: -1,
                right.map { n-it }.max() ?: -1
        )
    }
}