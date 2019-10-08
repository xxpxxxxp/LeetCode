package com.ypwang.easy

class Solution1217 {
    fun minCostToMoveChips(chips: IntArray): Int = chips.count { it % 2 == 0 }.let { minOf(it, chips.size - it) }
}