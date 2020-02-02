package com.ypwang.medium

import java.lang.Exception

class Solution1342 {
    fun minSetSize(arr: IntArray): Int {
        val size = arr.size
        val count = arr.groupBy { it }.mapValues { it.value.size }.toList().sortedByDescending { it.second }

        var rst = 0
        var removed = 0
        for ((_, c) in count) {
            removed += c
            rst++

            if (removed * 2 >= size) return rst
        }

        throw Exception("")
    }
}