package com.ypwang.medium

class Solution1493 {
    fun longestSubarray(nums: IntArray): Int {
        val zeros = nums.withIndex().filter { it.value == 0 }.map { it.index }
        if (zeros.size < 2) return nums.size - maxOf(zeros.size, 1)

        val idx = (listOf(-1) + zeros + listOf(nums.size)).toTypedArray()
        var len = 0
        for (i in 0 until idx.size - 2) {
            len = maxOf(len, idx[i+2] - idx[i] - 2)
        }

        return len
    }
}

fun main() {
    println(Solution1493().longestSubarray(intArrayOf(1,0,0,0,0)))
    println(Solution1493().longestSubarray(intArrayOf(1,1,0,1)))
    println(Solution1493().longestSubarray(intArrayOf(0,1,1,1,0,1,1,0,1)))
    println(Solution1493().longestSubarray(intArrayOf(1,1,1)))
    println(Solution1493().longestSubarray(intArrayOf(1,1,0,0,1,1,1,0,1)))
    println(Solution1493().longestSubarray(intArrayOf(0,0,0)))
}