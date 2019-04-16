package com.ypwang.medium

class Solution967 {
    fun numsSameConsecDiff(N: Int, K: Int): IntArray {
        if (N == 0) return intArrayOf()
        if (N == 1) return (0..9).toList().toIntArray()
        return numsSameConsecDiff(N-1, K).flatMap {
            if (it == 0) listOf<Int>()
            else {
                val m = it % 10
                val rst = mutableListOf<Int>()
                if (m + K < 10) rst.add(it * 10 + m + K)
                if (K != 0 && m - K >= 0) rst.add(it * 10 + m - K)
                rst
            }
        }.toIntArray()
    }
}

fun main() {
    println(Solution967().numsSameConsecDiff(2, 0).toList())
}