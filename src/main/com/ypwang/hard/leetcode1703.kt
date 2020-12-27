package com.ypwang.hard

class Solution1703 {
    fun minMoves(nums: IntArray, k: Int): Int {
        val b = mutableListOf(0L)
        for (i in nums.indices) {
            if (nums[i] == 1) {
                b.add(b.last() + i)
            }
        }

        var rst = Long.MAX_VALUE
        for (i in 0 until b.size - k) {
            rst = minOf(rst, b[i+k] + b[i] - b[i+k/2] - b[i+(k+1)/2])
        }

        return (rst - (k / 2) * ((k+1) / 2)).toInt()
    }
}