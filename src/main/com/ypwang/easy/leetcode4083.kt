package com.ypwang.easy

class Solution4083 {
    fun minDeletions(nums: IntArray): Int =
        nums.size - nums.fold(0 to 0) { (rst, n), i ->
            rst + (if (n != i) 1 else 0) to i
        }.first
}
