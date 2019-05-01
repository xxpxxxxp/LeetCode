package com.ypwang.medium

class Solution491 {
    fun findSubsequences(nums: IntArray): List<List<Int>> {
        val rst = mutableSetOf<List<Int>>(listOf())

        for (num in nums) {
            rst.addAll(rst.filter { it.isEmpty() || it.last() <= num }.map { it + num })
        }

        return rst.filter { it.size > 1 }
    }
}

fun main() {
    println(Solution491().findSubsequences(intArrayOf(4,6,7,7)))
}