package com.ypwang.medium

class Solution2906 {
    fun constructProductMatrix(grid: Array<IntArray>): Array<IntArray> {
        //the concept here used is as same as the product of the array except self
        val n = grid.size
        val m = grid[0].size
        val productES = Array(n) { IntArray(m) }
        var prefixProduct = 1L
        for (i in 0 until n) {
            for (j in 0 until m) {
                productES[i][j] = (prefixProduct % 12345L).toInt()
                prefixProduct = prefixProduct * grid[i][j] % 12345L
            }
        }
        var suffixProduct = 1L
        for (i in n - 1 downTo 0) {
            for (j in m - 1 downTo 0) {
                productES[i][j] = (productES[i][j] * suffixProduct % 12345L).toInt()
                suffixProduct = suffixProduct * grid[i][j] % 12345L
            }
        }
        return productES
    }
}