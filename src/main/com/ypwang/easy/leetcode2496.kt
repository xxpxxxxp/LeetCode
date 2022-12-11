package com.ypwang.easy

class Solution2496 {
    fun maximumValue(strs: Array<String>): Int =
        strs.map { it.toIntOrNull() ?: it.length }.max()
}