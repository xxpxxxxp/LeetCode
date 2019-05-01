package com.ypwang.medium

class Solution698 {
    class context(val nums: IntArray, val target: Int) {
        private val cache = mutableMapOf(0 to true)

        fun construct(available: Int): Boolean {
            if (available !in cache) {
                var i = 0
                while ((1 shl i) and available == 0) {
                    i++
                }

                cache[available] = fit(i+1, (1 shl i) xor available, target - nums[i])
            }
            return cache[available]!!
        }

        private fun fit(idx: Int, available: Int, left: Int): Boolean {
            if (left == 0) return construct(available)
            for (i in idx until nums.size) {
                if ((1 shl i) and available != 0) {      // number available
                    if (left >= nums[i] && fit(i + 1,(1 shl i) xor available,left - nums[i])) {          // possible to construct from current number
                        return true
                    }
                }
            }
            return false
        }
    }

    fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
        val sum = nums.sum()
        if (sum % k != 0) return false
        val target = sum / k

        if (nums.any { it > target }) return false
        nums.sortDescending()

        return context(nums, target).construct((1 shl nums.size) - 1)
    }
}

fun main() {
    println(Solution698().canPartitionKSubsets(intArrayOf(4, 3, 2, 3, 5, 2, 1), 4))
}