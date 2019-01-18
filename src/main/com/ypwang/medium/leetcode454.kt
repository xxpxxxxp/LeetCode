package com.ypwang.medium

class Solution454 {
    fun fourSumCount(A: IntArray, B: IntArray, C: IntArray, D: IntArray): Int {
        val m = A.flatMap { a ->
            B.map { a + it }
        }.groupBy { it }.mapValues { it.value.size }

        return C.flatMap { c ->
            D.map { c + it }
        }.sumBy { m.getOrDefault(-it, 0) }
    }
}