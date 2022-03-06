package com.ypwang.easy

class Solution2190 {
    fun mostFrequent(nums: IntArray, key: Int): Int {
        val counter = mutableMapOf<Int, Int>()
        for (i in 0 until nums.lastIndex) {
            if (nums[i] == key) {
                val n = nums[i+1]
                counter[n] = 1 + counter.getOrDefault(n, 0)
            }
        }

        return counter.toList().maxByOrNull { it.second }!!.first
    }
}