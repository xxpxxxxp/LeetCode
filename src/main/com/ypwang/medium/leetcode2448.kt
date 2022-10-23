package com.ypwang.medium

class Solution2448 {
    fun minCost(nums: IntArray, cost: IntArray): Long {
        fun calc(x: Int): Long =
            nums.zip(cost).map { Math.abs(it.first - x).toLong() * it.second }.sum()

        var l = nums.min()!!
        var r = nums.max()!!
        while (l < r) {
            val x = (l + r) / 2
            val cx = calc(x)
            val cx1 = calc(x+1)
            if (cx < cx1)
                r = x
            else
                l = x+1
        }
        return calc(l)
    }
}