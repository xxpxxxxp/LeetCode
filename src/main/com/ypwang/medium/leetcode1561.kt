package com.ypwang.medium

class Solution1561 {
    fun maxCoins(piles: IntArray): Int {
        piles.sortDescending()
        return (0 until piles.size / 3).sumBy { piles[2 * it + 1] }
    }
}