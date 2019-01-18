package com.ypwang.easy

class Solution219 {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val m = nums.take(k+1).groupBy { it }.mapValues { it.value.size }.toMutableMap()
        if (m.any { it.value > 1 }) {
            return true
        }

        for (i in k+1 until nums.size) {
            val pre = nums[i-k-1]
            m[pre] = m[pre]!! - 1
            m[nums[i]] = m.getOrDefault(nums[i], 0) + 1
            if (m.any { it.value > 1 }) {
                return true
            }
        }
        return false
    }
}
