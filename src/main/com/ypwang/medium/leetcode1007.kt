package com.ypwang.medium

class Solution1007 {
    fun minDominoRotations(A: IntArray, B: IntArray): Int {
        if (A.isEmpty()) {
            return 0
        }

        val t = (A + B).groupBy { it }.mapValues { it.value.size }.maxBy { it.value }!!

        if (t.value < A.size) {
            return -1
        }

        val a = A.withIndex().filter { it.value == t.key }.map { it.index }.toSet()
        val b = B.withIndex().filter { it.value == t.key }.map { it.index }.toSet()

        if ((a + b).size != A.size) {
            return -1
        }

        return minOf(A.size - a.size, A.size - b.size)
    }
}