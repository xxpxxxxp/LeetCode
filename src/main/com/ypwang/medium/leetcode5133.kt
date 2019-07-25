package com.ypwang.medium

class Solution5133 {
    fun maxAbsValExpr(arr1: IntArray, arr2: IntArray): Int {
        var rst = Int.MIN_VALUE
        val ps = intArrayOf(-1, 1)
        for (m in ps) {
            for (n in ps) {
                var closest = m * arr1[0] + n * arr2[0]
                for (i in 1 until arr1.size) {
                    val t = m * arr1[i] + n * arr2[i] + i
                    rst = maxOf(rst, t - closest)
                    closest = minOf(closest, t)
                }
            }
        }

        return rst
    }
}