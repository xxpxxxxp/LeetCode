package com.ypwang.easy

class Solution2404 {
    fun mostFrequentEven(nums: IntArray): Int {
        val f = nums.filter { it % 2 == 0 }.groupBy { it }.mapValues { it.value.size }
        val max = f.map { it.value }.maxOrNull() ?: return -1
        return f.filter { it.value == max }.minByOrNull { it.key }!!.key
    }
}