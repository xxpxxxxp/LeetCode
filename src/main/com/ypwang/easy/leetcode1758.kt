package com.ypwang.easy

class Solution1758 {
    fun minOperations(s: String): Int =
        minOf(s.withIndex().count { it.value - '0' != it.index % 2 }, s.withIndex().count { it.value - '0' == it.index % 2 })
}