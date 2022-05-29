package com.ypwang.easy

class Solution2283 {
    fun digitCount(num: String): Boolean {
        val m = num.groupBy { it }.map { (it.key - '0') to it.value.size }.toMap()
        return num.withIndex().all { (i, v) -> v - '0' == (m[i] ?: 0) }
    }
}