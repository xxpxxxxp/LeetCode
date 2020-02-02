package com.ypwang.easy

class Solution1331 {
    fun arrayRankTransform(arr: IntArray): IntArray {
        val map = arr.toSet().sorted().withIndex().map { it.value to it.index + 1 }.toMap()
        return arr.map { map[it]!! }.toIntArray()
    }
}