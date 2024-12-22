package com.ypwang.easy

class Solution3396 {
    fun minimumOperations(nums: IntArray): Int {
        val set = mutableSetOf<Int>()
        for (i in nums.lastIndex downTo 0) {
            val j = nums[i]
            if (j in set)
                return 1 + i / 3
            set.add(j)
        }

        return 0
    }
}

fun main() {
    println(Solution3396().minimumOperations(intArrayOf(5, 5)))
}