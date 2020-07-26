package com.ypwang.medium

class Solution1524 {
    fun numOfSubarrays(arr: IntArray): Int {
        val mod = 1000000007
        // even, odd
        val count = intArrayOf(1, 0)

        var sum = 0
        var rst = 0
        for (c in arr) {
            sum += c
            when (sum % 2) {
                0 -> {
                    rst = (rst + count[1]) % mod
                    count[0]++
                }
                1 -> {
                    rst = (rst + count[0]) % mod
                    count[1]++
                }
            }
        }

        return rst
    }
}