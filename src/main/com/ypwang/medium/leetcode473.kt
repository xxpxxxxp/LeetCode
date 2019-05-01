package com.ypwang.medium

class Solution473 {
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

    fun makesquare(nums: IntArray): Boolean {
        if (nums.isEmpty()) return false
        val sum = nums.sum()
        if (sum % 4 != 0) return false
        val target = sum / 4

        if (nums.any { it > target }) return false
        nums.sortDescending()

        return context(nums, target).construct((1 shl nums.size) - 1)
    }
}