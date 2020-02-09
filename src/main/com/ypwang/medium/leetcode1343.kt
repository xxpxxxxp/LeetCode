package com.ypwang.medium

class Solution1343 {
    fun numOfSubarrays(arr: IntArray, k: Int, threshold: Int): Int {
        val sum = k * threshold
        var count = 0
        var window = arr.take(k).sum()

        if (window >= sum) count++

        for (i in k until arr.size) {
            window -= arr[i - k]
            window += arr[i]
            if (window >= sum) count++
        }

        return count
    }
}