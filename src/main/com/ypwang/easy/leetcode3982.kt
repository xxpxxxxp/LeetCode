package com.ypwang.easy

class Solution3982 {
    fun maxDigitRange(nums: IntArray): Int {
        val m = nums.map {
            val ds = it.toString()
            val max = ds.max()
            val min = ds.min()

            max - min to it
        }

        val max = m.maxOf { it.first }
        return m.filter { it.first == max }.sumOf { it.second }
    }
}
