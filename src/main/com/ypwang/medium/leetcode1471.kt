package com.ypwang.medium

class Solution1471 {
    fun getStrongest(arr: IntArray, k: Int): IntArray {
        arr.sort()
        val median = arr[(arr.size-1) / 2].toDouble()

        var m = 0
        var n = arr.lastIndex
        val rst = IntArray(k)

        for (i in rst.indices) {
            val left = Math.abs(median - arr[m])
            val right = Math.abs(arr[n] - median)
            rst[i] = if (left > right) arr[m++] else arr[n--]
        }

        return rst
    }
}