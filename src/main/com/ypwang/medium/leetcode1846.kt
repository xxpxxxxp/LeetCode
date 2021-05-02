package com.ypwang.medium

class Solution1846 {
    fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int {
        arr.sort()
        var cur = 0
        for (i in arr.indices) {
            arr[i] = minOf(cur+1, arr[i])
            cur = arr[i]
        }

        return arr.last()
    }
}