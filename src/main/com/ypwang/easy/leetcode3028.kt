package com.ypwang.easy

class Solution3028 {
    fun returnToBoundaryCount(nums: IntArray): Int =
        nums.fold(0 to 0) { (c, sum), n ->
            (if (sum + n == 0) c+1 else c) to sum + n
        }.first
}