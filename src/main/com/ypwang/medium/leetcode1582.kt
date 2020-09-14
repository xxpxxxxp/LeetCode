package com.ypwang.medium

class Solution1582 {
    fun numSpecial(mat: Array<IntArray>): Int {
        val row = IntArray(mat.size)
        val col = IntArray(mat[0].size)

        for ((i, r) in mat.withIndex()) {
            for ((j, v) in r.withIndex()) {
                if (v == 1) {
                    row[i]++
                    col[j]++
                }
            }
        }

        var rst = 0
        for ((i, r) in mat.withIndex()) {
            for ((j, v) in r.withIndex()) {
                if (v == 1) {
                    if (row[i] == 1 && col[j] == 1)
                        rst++
                }
            }
        }

        return rst
    }
}