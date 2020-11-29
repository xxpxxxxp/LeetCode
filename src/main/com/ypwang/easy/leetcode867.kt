package com.ypwang.easy

class Solution867 {
    fun transpose(A: Array<IntArray>): Array<IntArray> {
        val numcol = A[0].size
        val rst = Array(numcol){IntArray(A.size){0}}
        for (i in 0 until A.size) {
            for (j in 0 until numcol) {
                rst[j][i] = A[i][j]
            }
        }
        return rst
    }
}

fun main() {
    println(Solution867().transpose(arrayOf(intArrayOf(1,0), intArrayOf(0,2))))
}