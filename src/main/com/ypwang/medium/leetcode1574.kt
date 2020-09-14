package com.ypwang.medium

class Solution1574 {
    fun findLengthOfShortestSubarray(arr: IntArray): Int {
        var i = -1
        var j = arr.size
        var value = Int.MAX_VALUE

        while (j > 0 && value >= arr[j-1]) {
            value = arr[--j]
        }

        var rst = j
        if (rst == 0)
            return 0

        value = Int.MIN_VALUE
        while (i < arr.lastIndex && value <= arr[i+1]) {
            value = arr[++i]

            while (j < arr.size && arr[j] < arr[i])
                j++

            rst = minOf(rst, j - i - 1)
        }

        return rst
    }
}