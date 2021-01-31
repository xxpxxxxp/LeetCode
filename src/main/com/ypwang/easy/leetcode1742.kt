package com.ypwang.easy

class Solution1742 {
    fun countBalls(lowLimit: Int, highLimit: Int): Int {
        val count = IntArray(46)
        (lowLimit..highLimit).map { it.toString().map { c -> c - '0' }.sum() }.forEach { count[it]++ }
        return count.max()!!
    }
}