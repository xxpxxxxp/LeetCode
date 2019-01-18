package com.ypwang.medium

import java.util.*

class Solution384(val nums: IntArray) {

    /** Resets the array to its original configuration and return it. */
    fun reset(): IntArray = nums

    /** Returns a random shuffling of the array. */
    fun shuffle(): IntArray {
        val copy = nums.copyOf()
        val rand = Random()
        for (i in nums.lastIndex downTo 1) {
            val j = rand.nextInt(i+1)
            if (i != j) {
                val tmp = copy[i]
                copy[i] = copy[j]
                copy[j] = tmp
            }
        }
        return copy
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(nums)
 * var param_1 = obj.reset()
 * var param_2 = obj.shuffle()
 */