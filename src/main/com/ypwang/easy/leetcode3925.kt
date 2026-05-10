package com.ypwang.easy

class Solution3925 {
    fun concatWithReverse(nums: IntArray): IntArray =
        (nums.toList() + nums.reversed()).toIntArray()
}
