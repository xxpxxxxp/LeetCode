package com.ypwang.easy

class Solution2078 {
    fun maxDistance(colors: IntArray): Int =
        maxOf(0, colors.indexOfLast { it != colors[0] }, colors.lastIndex - colors.indexOfFirst { it != colors.last() })
}