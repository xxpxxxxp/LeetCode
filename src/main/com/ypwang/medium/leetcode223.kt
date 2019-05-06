package com.ypwang.medium

class Solution223 {
    fun computeArea(A: Int, B: Int, C: Int, D: Int, E: Int, F: Int, G: Int, H: Int): Int {
        val x = minOf(C, G).toLong() - maxOf(A, E).toLong()
        val y = minOf(D, H).toLong() - maxOf(B, F).toLong()

        val overlap = if (x > 0 && y > 0) x * y else 0
        return (C-A)*(D-B) + (G-E)*(H-F) - overlap.toInt()
    }
}

fun main() {
    println(Solution223().computeArea(
            -1500000001,
            0,
            -1500000000,
            1,
            1500000000,
            0,
            1500000001,
            1
    ))
}