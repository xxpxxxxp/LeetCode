package com.ypwang.hard

class Solution1761 {
    fun minTrioDegree(n: Int, edges: Array<IntArray>): Int {
        val mat = Array(n) { BooleanArray(n) }
        val count = IntArray(n)

        for ((i, j) in edges) {
            mat[i-1][j-1] = true
            mat[j-1][i-1] = true
            count[i-1]++
            count[j-1]++
        }

        var rst = Int.MAX_VALUE
        for (i in 0 until n) {
            for (j in i+1 until n) {
                if (mat[i][j]) {
                    for (z in j+1 until n) {
                        if (mat[i][z] && mat[j][z]) {
                            rst = minOf(rst, count[i] + count[j] + count[z] - 6)
                        }
                    }
                }
            }
        }

        return if (rst == Int.MAX_VALUE) -1 else rst
    }
}