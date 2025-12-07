package com.ypwang.easy

class Solution3769 {
    fun sortByReflection(nums: IntArray): IntArray =
        nums.map { it to it.toString(2).reversed().toInt(2) }
            .sortedWith(compareBy<Pair<Int, Int>> { it.second }.thenBy { it.first })
            .map { it.first }
            .toIntArray()
}
