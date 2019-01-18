package com.ypwang.medium

class Solution931 {
    fun minFallingPathSum(A: Array<IntArray>): Int {
        var rst = A[0].toTypedArray()

        for (i in 1 until A.size) {
            val col = A[i].toTypedArray()
            for (j in 0 until col.size) {
                var min = rst[j]
                if (j > 0) {
                    min = Math.min(min, rst[j-1])
                }
                if (j < col.lastIndex) {
                    min = Math.min(min, rst[j+1])
                }
                col[j] = col[j] + min
            }
            rst = col
        }

        return rst.min()!!
    }
}

fun main(args: Array<String>) {
    println(Solution931().minFallingPathSum(
            arrayOf(
                    intArrayOf(1,2,3),
                    intArrayOf(4,5,6),
                    intArrayOf(7,8,9)
            )
    ))
}