package com.ypwang.easy

class Solution1431 {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): BooleanArray {
        val rst = BooleanArray(candies.size)
        val max = candies.maxOrNull()!!
        for ((i, v) in candies.withIndex()) {
            rst[i] = v + extraCandies >= max
        }

        return rst
    }
}