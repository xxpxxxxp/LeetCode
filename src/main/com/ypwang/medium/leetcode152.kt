package com.ypwang.medium

class Solution152 {
    fun maxProduct(nums: IntArray): Int {
        if (nums.isEmpty())
            return 0

        var max = nums[0]
        var initial = Pair(nums[0], nums[0])

        for (i in 1 until nums.size) {
            val t = intArrayOf(nums[i], nums[i] * initial.first, nums[i] * initial.second)
            initial = Pair(t.minOrNull()!!, t.maxOrNull()!!)

            if (initial.second > max) {
                max = initial.second
            }
        }

        return max
    }
}

fun main() {
    println(Solution152().maxProduct(intArrayOf(-2, 0, -1)))
}