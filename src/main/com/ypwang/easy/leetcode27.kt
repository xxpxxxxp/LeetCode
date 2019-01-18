package com.ypwang.easy

class Solution27 {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var j = 0
        for (i in 0 until nums.size) {
            if (nums[i] != `val`) {
                nums[j] = nums[i]
                j++
            }
        }
        return j
    }
}
