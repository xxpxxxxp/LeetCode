package com.ypwang.easy

class Solution908 {
    fun smallestRangeI(A: IntArray, K: Int): Int {
        val rst = A.max()!! - A.min()!! - 2 * K
        return Math.max(0, rst)
    }
}