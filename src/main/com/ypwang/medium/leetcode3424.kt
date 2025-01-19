package com.ypwang.medium

class Solution3424 {
    fun minCost(arr: IntArray, brr: IntArray, k: Long): Long {
        var res1 = 0L
        var res2 = 0L
        for (i in arr.indices)
            res1 += Math.abs(arr[i] - brr[i])
        arr.sort()
        brr.sort()
        for (i in arr.indices)
            res2 += Math.abs(arr[i] - brr[i])

        return minOf(res1, res2 + k)
    }
}
