package com.ypwang.medium

class Solution417 {
    fun pacificAtlantic(matrix: Array<IntArray>): List<IntArray> {
        if (matrix.isEmpty())
            return listOf()

        val m = matrix.size
        val n = matrix[0].size
        val pacific = mutableSetOf<Int>()
        val atlantic = mutableSetOf<Int>()

        fun index(i: Int, j: Int) = i * n + j

        fun searchPacific(i: Int, j: Int) {
            if (index(i, j) !in pacific) {
                pacific.add(index(i, j))

                val cur = matrix[i][j]
                if (i > 0 && matrix[i-1][j] >= cur) searchPacific(i-1, j)
                if (i < m-1 && matrix[i+1][j] >= cur) searchPacific(i+1, j)
                if (j > 0 && matrix[i][j-1] >= cur) searchPacific(i, j-1)
                if (j < n-1 && matrix[i][j+1] >= cur) searchPacific(i, j+1)
            }
        }

        fun searchAtlantic(i: Int, j: Int) {
            if (index(i, j) !in atlantic) {
                atlantic.add(index(i, j))

                val cur = matrix[i][j]
                if (i > 0 && matrix[i-1][j] >= cur) searchAtlantic(i-1, j)
                if (i < m-1 && matrix[i+1][j] >= cur) searchAtlantic(i+1, j)
                if (j > 0 && matrix[i][j-1] >= cur) searchAtlantic(i, j-1)
                if (j < n-1 && matrix[i][j+1] >= cur) searchAtlantic(i, j+1)
            }
        }

        for (i in 0 until m) {
            searchPacific(i, 0)
            searchAtlantic(i, n-1)
        }

        for (j in 0 until n) {
            searchPacific(0, j)
            searchAtlantic(m-1, j)
        }

        return pacific.intersect(atlantic).map { intArrayOf(it/n, it%n) }
    }
}

fun main() {
    println(Solution417().pacificAtlantic(arrayOf(
            intArrayOf(1,2,2,3,5), intArrayOf(3,2,3,4,4), intArrayOf(2,4,5,3,1), intArrayOf(6,7,1,4,5), intArrayOf(5,1,1,2,4)
    )).map { it.toList() })
}