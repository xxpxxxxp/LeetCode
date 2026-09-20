package com.ypwang.easy

class Solution4048 {
    fun countSpecialIntegers(nums: IntArray): Int {
        val freq = HashMap<Int, MutableList<Int>>()

        for (i in nums.indices)
            freq.getOrPut(nums[i]) { mutableListOf() }.add(i)

        var ans = 0
        for ((_, indices) in freq)
            if (indices.size == 3 &&
                indices[1] - indices[0] == indices[2] - indices[1]
            )
                ans++

        return ans
    }
}
