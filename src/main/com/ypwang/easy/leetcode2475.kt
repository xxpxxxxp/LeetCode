package com.ypwang.easy

class Solution2475 {
    fun unequalTriplets(nums: IntArray): Int =
        nums.groupBy { it }.map { it.value.size }.fold(Triple(0, 0, nums.size)) { (rst, left, right), cnt ->
            Triple(rst + left * cnt * (right - cnt), left + cnt, right - cnt)
        }.first
}