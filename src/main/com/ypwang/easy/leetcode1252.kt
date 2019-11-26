package com.ypwang.easy

class Solution1252 {
    fun oddCells(n: Int, m: Int, indices: Array<IntArray>): Int {
        val r = IntArray(n)
        val c = IntArray(m)

        for ((i, j) in indices) {
            r[i]++
            c[j]++
        }

        return (0 until n).map { i ->
            (0 until m).count { j ->
                (r[i] + c[j]) % 2 == 1 }
        }.sum()
    }
}