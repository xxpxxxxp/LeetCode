package com.ypwang.easy

class Solution3701 {
    fun alternatingSum(nums: IntArray): Int =
        nums.withIndex().sumOf {
            if (it.index % 2 == 0)
                it.value
            else
                -it.value
        }
}
