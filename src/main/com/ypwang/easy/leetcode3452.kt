package com.ypwang.easy

class Solution3452 {
    fun sumOfGoodNumbers(nums: IntArray, k: Int): Int =
        nums.withIndex().filter { (i, v) ->
            (i - k < 0 || v > nums[i - k]) &&
                    (i + k >= nums.size || v > nums[i + k])
        }.sumOf { it.value }
}
