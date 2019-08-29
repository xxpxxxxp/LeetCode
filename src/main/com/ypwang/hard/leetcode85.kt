package com.ypwang.hard

import java.util.*

class Solution85 {
    fun maximalRectangle(matrix: Array<CharArray>): Int {
        if (matrix.isEmpty()) return 0

        var max = 0
        val stack = Stack<Int>()     // index
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                val pre =
                        when (matrix[i][j]) {
                            '1' -> 1 + if (i == 0) 0 else matrix[i-1][j].toInt()
                            else -> 0
                        }

                while (stack.isNotEmpty() && matrix[i][stack.peek()].toInt() > pre) {
                    val tp = stack.pop()
                    val cur = matrix[i][tp].toInt() * (if (stack.isEmpty()) j else j - stack.peek() - 1)
                    max = maxOf(cur, max)
                }

                stack.push(j)
                matrix[i][j] = pre.toChar()
            }

            while (stack.isNotEmpty()) {
                val tp = stack.pop()
                val cur = matrix[i][tp].toInt() * (if (stack.isEmpty()) matrix[0].size else matrix[0].size - stack.peek() - 1)
                max = maxOf(cur, max)
            }
        }

        return max
    }
}

fun main() {
    println(Solution85().maximalRectangle(arrayOf(
            "1010".toCharArray(),
            "1011".toCharArray(),
            "1011".toCharArray(),
            "1111".toCharArray()
    )))
}