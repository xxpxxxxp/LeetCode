package com.ypwang.easy

class Solution1207 {
    fun uniqueOccurrences(arr: IntArray): Boolean =
            arr.groupBy { it }.map { it.value.size }.groupBy { it }.all { it.value.size == 1 }
}