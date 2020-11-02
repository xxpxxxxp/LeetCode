package com.ypwang.easy

class Solution1636 {
    fun frequencySort(nums: IntArray): IntArray =
        nums.groupBy { it }
                .mapValues { it.value.size }
                .toList()
                .sortedWith(compareBy<Pair<Int, Int>> { it.second }.thenByDescending { it.first })
                .map { kv -> List(kv.second){ kv.first } }
                .reduce { acc, list -> acc + list }
                .toIntArray()
}