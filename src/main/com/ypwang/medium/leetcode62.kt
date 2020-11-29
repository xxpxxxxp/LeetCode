package com.ypwang.medium

class Solution62 {
    fun uniquePaths(m: Int, n: Int): Int {
        val r = IntArray(m * n){0}

        for (i in 0 until n) {
            r[i*m + m-1] = 1
        }

        for (i in 0 until m) {
            r[m*(n-1) + i] = 1
        }

        for (i in (n-2) downTo 0) {
            for (j in (m-2) downTo 0) {
                r[i*m+j] = r[i*m+j+1] + r[(i+1)*m+j]
            }
        }

        return r[0]
    }
}

fun main() {
    println(Solution62().uniquePaths(3, 2))
}