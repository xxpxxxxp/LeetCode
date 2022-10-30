package com.ypwang.medium

class Solution2453 {
    fun destroyTargets(nums: IntArray, space: Int): Int {
        val groups = nums.groupBy { it % space }.map { it.value }
        val maxSize = groups.map { it.size }.max()!!
        return groups.filter { it.size == maxSize }.flatten().min()
    }
}

fun main() {
    println(Solution2453().destroyTargets(intArrayOf(1,3,5,2,4,6), 2))
}