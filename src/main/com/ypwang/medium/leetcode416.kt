package com.ypwang.medium

class Solution416 {
    fun canPartition(nums: IntArray): Boolean {
        val sum = nums.sum()
        if (sum % 2 == 1)
            return false

        // calc first from second as index exist or not
        val cache = mutableMapOf<Pair<Int, Int>, Boolean>()

        fun helper(target: Int, startIndex: Int): Boolean {
            if (target == 0)
                return true

            if (startIndex == nums.size)
                return false

            if (Pair(target, startIndex) !in cache)
                cache[Pair(target, startIndex)] = helper(target - nums[startIndex], startIndex + 1) || helper(target, startIndex + 1)

            return cache[Pair(target, startIndex)]!!
        }

        return helper(sum / 2, 0)
    }
}

fun main() {
    println(Solution416().canPartition(intArrayOf(1, 5, 11, 5)))
}