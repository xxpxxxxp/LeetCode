package com.ypwang.easy

class Solution1929 {
    fun getConcatenation(nums: IntArray): IntArray {
        val rst = IntArray(nums.size * 2)
        nums.copyInto(rst, 0)
        nums.copyInto(rst, nums.size)

        return rst
    }
}