package com.ypwang.hard

class Solution2732 {
    fun goodSubsetofBinaryMatrix(grid: Array<IntArray>): List<Int> {
        val vec = grid.map {
            it.withIndex().fold(0) { cur, (i, v) ->
                cur or (v shl i)
            }
        }

        for ((i, r1) in vec.withIndex()) {
            if (r1 == 0)
                return listOf(i)

            for (j in i+1 until vec.size) {
                if (r1 and vec[j] == 0)
                    return listOf(i, j)
            }
        }

        return listOf()
    }
}