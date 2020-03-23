package com.ypwang.easy

class Solution1389 {
    fun createTargetArray(nums: IntArray, index: IntArray): IntArray {
        val rst = mutableListOf<Int>()
        for ((i, v) in index.zip(nums)) {
            rst.add(i, v)
        }
        return rst.toIntArray()
    }
}