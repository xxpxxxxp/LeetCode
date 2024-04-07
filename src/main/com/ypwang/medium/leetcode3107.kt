package com.ypwang.medium

class Solution3107 {
    fun minOperationsToMakeMedianK(nums: IntArray, k: Int): Long {
        nums.sort()
        val midIdx = nums.size / 2

        return nums.withIndex().fold(0L) { sum, iv ->
            val (i, v) = iv
            if (i < midIdx)
                sum + maxOf(v - k , 0)
            else if (i > midIdx)
                sum + maxOf(k - v, 0)
            else
                sum + Math.abs(k - v)
        }
    }
}

fun main() {
    println(Solution3107().minOperationsToMakeMedianK(intArrayOf(2,5,6,8,5), 4))
}