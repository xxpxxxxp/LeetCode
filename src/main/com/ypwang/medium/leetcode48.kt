package com.ypwang.medium

class Solution48 {
    fun rotate(matrix: Array<IntArray>): Unit {
        val size = matrix.size
        fun roll(depth: Int, step: Int) {
            val tmp = matrix[depth][step]
            matrix[depth][step] = matrix[size-1-step][depth]
            matrix[size-1-step][depth]= matrix[size-1-depth][size-1-step]
            matrix[size-1-depth][size-1-step] = matrix[step][size-1-depth]
            matrix[step][size-1-depth] = tmp
        }

        for (i in 0 until size / 2) {
            for (j in i until size - i - 1) {
                roll(i, j)
            }
        }
    }
}

fun main() {
    println(Solution48().rotate(arrayOf(
            intArrayOf(5,1,9,11),
            intArrayOf(2,4,8,10),
            intArrayOf(13,3,6,7),
            intArrayOf(15,14,12,16)
    )))
}