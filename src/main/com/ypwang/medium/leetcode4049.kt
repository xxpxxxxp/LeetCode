package com.ypwang.medium

class Solution4049 {
    fun countSpecialIntegers(nums: IntArray): Int {
        val freq = HashMap<Int, MutableList<Int>>()

        // Store indices of each number
        for (i in nums.indices)
            freq.getOrPut(nums[i]) { mutableListOf() }.add(i)

        var ans = 0
        for ((_, indices) in freq) {
            if (indices.size < 3)
                continue

            val diff = indices[1] - indices[0]
            var valid = true

            for (i in 2 until indices.size) {
                if (indices[i] - indices[i - 1] != diff) {
                    valid = false
                    break
                }
            }

            if (valid)
                ans++
        }

        return ans
    }
}
