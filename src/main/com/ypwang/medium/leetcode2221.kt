package com.ypwang.medium

class Solution2221 {
    fun triangularSum(nums: IntArray): Int {
        for (i in 0 until nums.lastIndex) {
            for (j in 1 until nums.size-i)
                nums[j-1] = (nums[j-1] + nums[j]) % 10
        }

        return nums[0]
    }
}

fun main() {
    println(Solution2221().triangularSum(intArrayOf(1,2,3,4,5)))
}