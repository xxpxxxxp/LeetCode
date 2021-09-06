package com.ypwang.medium

class Solution1992 {
    fun findFarmland(land: Array<IntArray>): Array<IntArray> {
        val m = land.size
        val n = land[0].size
        val rst = mutableListOf<IntArray>()

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (land[i][j] == 0)
                    continue

                // search bottom most
                var x = i
                while (x < m && land[x][j] == 1)
                    x++

                // search right most
                var y = j
                while (y < n && land[i][y] == 1)
                    y++

                rst.add(intArrayOf(i, j, x-1, y-1))

                for (k in i until x) {
                    for (l in j until y) {
                        land[k][l] = 0
                    }
                }
            }
        }

        return rst.toTypedArray()
    }
}

fun main() {
    println(Solution1992().findFarmland(arrayOf(
        intArrayOf(1,1,0,0,0,1), intArrayOf(1,1,0,0,0,0)
    )))
}