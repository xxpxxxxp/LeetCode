package com.ypwang.medium

class Solution3075 {
    fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
        happiness.sortDescending()
        return (0 until k).fold(0L) { r, i ->
            r + maxOf(0, happiness[i] - i)
        }
    }
}
