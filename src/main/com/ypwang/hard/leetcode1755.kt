package com.ypwang.hard

class Solution1755 {
    fun minAbsDifference(nums: IntArray, goal: Int): Int {
        val set1 = mutableSetOf(0)
        val set2 = mutableSetOf(0)

        for (i in 0 until nums.size/2) {
            set1.addAll(set1.map { it + nums[i] })
        }

        for (i in nums.size/2 until nums.size) {
            set2.addAll(set2.map { it + nums[i] })
        }

        val ls = set1.sorted()
        var rst = Int.MAX_VALUE
        for (c in set2) {
            val remain = goal - c
            val idx = ls.binarySearch(remain).let { if (it >= 0) it else -it-1 }
            if (idx < ls.size) {
                rst = minOf(rst, Math.abs(remain - ls[idx]))
            }
            if (idx > 0) {
                rst = minOf(rst, Math.abs(remain - ls[idx-1]))
            }
        }

        return rst
    }
}