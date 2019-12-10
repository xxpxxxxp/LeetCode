package com.ypwang.medium

class Solution1276 {
    fun numOfBurgers(tomatoSlices: Int, cheeseSlices: Int): List<Int> {
        val a = tomatoSlices / 2.0 - cheeseSlices
        val b = 2 * cheeseSlices - tomatoSlices / 2.0

        if (tomatoSlices % 2 != 0 || a < 0 || b < 0) return listOf()
        return listOf(a.toInt(), b.toInt())
    }
}