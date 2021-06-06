package com.ypwang.easy

class Solution1886 {
    fun findRotation(mat: Array<IntArray>, target: Array<IntArray>): Boolean {
        val n = mat.size
        return listOf(
            { x: Int, y: Int -> x to y },
            { x: Int, y: Int -> y to n-1-x },
            { x: Int, y: Int -> n-1-x to n-1-y },
            { x: Int, y: Int -> n-1-y to x }
        ).any { lambda ->
            (0 until n).all { x ->
                (0 until n).all { y ->
                    val (i, j) = lambda(x, y)
                    mat[i][j] == target[x][y]
                }
            }
        }
    }
}