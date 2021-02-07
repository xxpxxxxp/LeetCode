package com.ypwang.medium

class Solution1753 {
    fun maximumScore(a: Int, b: Int, c: Int): Int {
        val (x, y, z) = listOf(a, b, c).sorted()
        val d = minOf(x + y, z)
        return (x + y + d) / 2
    }
}