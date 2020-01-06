package com.ypwang.hard

import java.util.*

class Solution363 {
    fun maxSumSubmatrix(matrix: Array<IntArray>, k: Int): Int {
        if (matrix.isEmpty()) return 0
        val row = matrix.size
        val col = matrix[0].size
        val m = minOf(row, col)
        val n = maxOf(row, col)
        val colIsBig = col > row
        var res = Int.MIN_VALUE
        for (i in 0 until m) {
            val array = IntArray(n)
            // sum from row j to row i
            for (j in i downTo 0) {
                var `val` = 0
                val set = TreeSet<Int>()
                set.add(0)
                //traverse every column/row and sum up
                for (p in 0 until n) {
                    array[p] += if (colIsBig) matrix[j][p] else matrix[p][j]
                    `val` += array[p]
                    //use TreeMap to binary search previous sum to get possible result
                    val subres = set.ceiling(`val` - k)
                    if (subres != null) {
                        res = maxOf(res, `val` - subres)
                    }
                    set.add(`val`)
                }
            }
        }
        return res
    }
}

fun main() {
    println(Solution363().maxSumSubmatrix(arrayOf(intArrayOf(2,2,-1)), 3))
}