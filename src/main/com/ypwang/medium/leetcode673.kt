package com.ypwang.medium

class Solution673 {
    fun findNumberOfLIS(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        val dpLen = IntArray(nums.size){1}
        val dpCount = IntArray(nums.size){1}
        for (i in 1 until nums.size) {
            val cur = nums[i]
            for (j in 0 until i) {
                if (cur > nums[j]) {
                    val len = 1 + dpLen[j]
                    if (len > dpLen[i]) {
                        dpLen[i] = len
                        dpCount[i] = 0
                    }
                    if (len == dpLen[i]) {
                        dpCount[i] += dpCount[j]
                    }
                }
            }
        }

        val max = dpLen.max()!!
        return dpLen.withIndex().filter { it.value == max }.sumBy { dpCount[it.index] }
    }
}

fun main() {
    println(Solution673().findNumberOfLIS(intArrayOf(2,2,2,2,2)))
}