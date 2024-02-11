package com.ypwang.easy

class Solution3033 {
    fun modifiedMatrix(matrix: Array<IntArray>): Array<IntArray> {
        val js = mutableListOf<Int>()
        for (i in 0 until matrix[0].size) {
            js.clear()
            var max = Int.MIN_VALUE
            for (j in 0 until matrix.size) {
                val t = matrix[j][i]
                if (t == -1)
                    js.add(j)
                else
                    max = maxOf(max, t)
            }

            for (j in js)
                matrix[j][i] = max
        }

        return matrix
    }
}