package com.ypwang.medium

class Solution1674 {
    fun minMoves(nums: IntArray, limit: Int): Int {
        val acc = IntArray(2 * limit)

        for (i in 0 until nums.size / 2) {
            val a = nums[i]
            val b = nums[nums.lastIndex - i]

            acc[0] += 2
            acc[minOf(a, b) - 1]--
            acc[a + b - 2]--
            acc[a + b - 1]++
            acc[maxOf(a, b) + limit - 1]++
        }

        return acc.fold(0 to Int.MAX_VALUE) { (c, rst), v -> c + v to minOf(c + v, rst) }.second
    }
}