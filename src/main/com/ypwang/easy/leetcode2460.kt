package com.ypwang.easy

class Solution2460 {
    fun applyOperations(nums: IntArray): IntArray {
        for (i in 0 until nums.lastIndex) {
            if (nums[i] == nums[i+1]) {
                nums[i] *= 2
                nums[i+1] = 0
            }
        }

        val nonzero = nums.filter { it != 0 }
        return (nonzero + List(nums.size - nonzero.size) {0}).toIntArray()
    }
}

fun main() {
    println(Solution2460().applyOperations(intArrayOf(1,2,2,1,1,0)))
}