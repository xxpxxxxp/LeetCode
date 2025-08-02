package com.ypwang.easy

class Solution3432 {
    fun countPartitions(nums: IntArray): Int =
        if (nums.sum()!! % 2 == 0)
            nums.size - 1
        else
            0
}
