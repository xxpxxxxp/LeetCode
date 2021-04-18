package com.ypwang.easy

class Solution1827 {
    fun minOperations(nums: IntArray): Int =
        nums.fold(Int.MIN_VALUE to 0) { (pre, sum), n ->
            val m = maxOf(pre+1, n)
            m to sum + m - n
        }.second
}