package com.ypwang.easy

class Solution1588 {
    fun sumOddLengthSubarrays(arr: IntArray): Int {
        var sum = 0
        val preSum = IntArray(2)
        var rst = 0
        for ((i, v) in arr.withIndex()) {
            sum += v
            preSum[i % 2] += sum
            rst += sum * (i / 2 + 1) - preSum[1 - (i % 2)]
        }

        return rst
    }
}