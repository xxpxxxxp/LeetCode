package com.ypwang.easy

class Solution1313 {
    fun decompressRLElist(nums: IntArray): IntArray {
        val rst = IntArray(nums.withIndex().filter { it.index % 2 == 0 }.sumBy { it.value })

        var i = 0
        var j = 0

        while (j < rst.size) {
            val v = nums[2 * i]
            val c = nums[2 * i + 1]

            for (k in 0 until v) {
                rst[j++] = c
            }
            i++
        }

        return rst
    }
}