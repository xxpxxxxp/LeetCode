package com.ypwang.easy

class Solution3731 {
    fun findMissingElements(nums: IntArray): List<Int> {
        val s = nums.toSet()
        val min = s.min()!!
        val max = s.max()!!

        return (min .. max).filter { it !in s }
    }
}
