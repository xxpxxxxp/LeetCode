package com.ypwang.medium

class Solution1329 {
    fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {
        val m = mat.size
        val n = mat[0].size
        fun sort(x: Int, y: Int) {
            val ls = mutableListOf<Int>()
            var i = 0
            while (x + i in 0 until m && y + i in 0 until n) {
                ls.add(mat[x+i][y+i])
                i++
            }
            val ay = ls.sorted().toIntArray()
            i = 0
            while (x + i in 0 until m && y + i in 0 until n) {
                mat[x+i][y+i] = ay[i]
                i++
            }
        }

        (0 until m).forEach { sort(it, 0) }
        (1 until n).forEach { sort(0, it) }

        return mat
    }
}