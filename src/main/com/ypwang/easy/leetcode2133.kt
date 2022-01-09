package com.ypwang.easy

class Solution2133 {
    fun checkValid(matrix: Array<IntArray>): Boolean {
        val n = matrix.size

        fun check(l: List<Int>): Boolean =
            l.all { it in 1 .. n } && l.toSet().size == n

        return (0 until n).all {
            check(matrix[it].toList()) && check((0 until n).map { j -> matrix[j][it] })
        }
    }
}