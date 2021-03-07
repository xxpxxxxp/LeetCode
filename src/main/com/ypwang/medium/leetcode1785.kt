package com.ypwang.medium

class Solution1785 {
    fun minElements(nums: IntArray, limit: Int, goal: Int): Int =
        ((Math.abs(goal.toLong() - nums.map { it.toLong() }.sum()) + limit - 1) / limit).toInt()
}