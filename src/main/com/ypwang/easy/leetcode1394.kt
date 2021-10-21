package com.ypwang.easy

class Solution1394 {
    fun findLucky(arr: IntArray): Int =
        arr.groupBy { it }.mapValues { it.value.size }.filter { it.key == it.value }.map { it.key }.maxOrNull() ?: -1
}