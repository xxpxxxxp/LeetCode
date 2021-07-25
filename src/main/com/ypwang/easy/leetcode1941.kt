package com.ypwang.easy

class Solution1941 {
    fun areOccurrencesEqual(s: String): Boolean =
        s.groupBy { it }.map { it.value.size }.groupBy { it }.size == 1
}