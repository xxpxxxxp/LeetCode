package com.ypwang.easy

class Solution3467 {
    fun transformArray(nums: IntArray): IntArray {
        val even = nums.count { it % 2 == 0 }
        return IntArray(nums.size) { if (it < even) 0  else 1 }
    }
}
