package com.ypwang.easy

class Solution2164 {
    fun sortEvenOdd(nums: IntArray): IntArray {
        val (even, odd) = nums.withIndex().partition { it.index % 2 == 0 }
        var i = 0
        for (v in even.map { it.value }.sorted())
            nums[2 * i++] = v

        i = 0
        for (v in odd.map { it.value }.sortedDescending())
            nums[1 + 2 * i++] = v

        return nums
    }
}