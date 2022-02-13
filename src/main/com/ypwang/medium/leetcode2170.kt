package com.ypwang.medium

class Solution2170 {
    fun minimumOperations(nums: IntArray): Int {
        if (nums.size < 2)
            return 0

        val (even, odd) = nums.withIndex().partition { it.index % 2 == 0 }
        val og = odd.map { it.value }.groupBy { it }.mapValues { it.value.size }.toList().sortedByDescending { it.second }.take(2)
        val eg = even.map { it.value }.groupBy { it }.mapValues { it.value.size }.toList().sortedByDescending { it.second }.take(2)

        if (og[0].first != eg[0].first)
            return nums.size - og[0].second - eg[0].second

        var l = og[0].second
        var r = eg[0].second
        if (og.size > 1)
            r += og[1].second

        if (eg.size > 1)
            l += eg[1].second

        return nums.size - maxOf(l, r)
    }
}

fun main() {
    println(Solution2170().minimumOperations(intArrayOf(3,1,3,2,4,3)))
}