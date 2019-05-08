package com.ypwang.easy

class Solution985 {
    fun sumEvenAfterQueries(A: IntArray, queries: Array<IntArray>): IntArray {
        val rst = IntArray(queries.size)
        var initial = A.filter { it % 2 == 0 }.sum()

        for ((i, q) in queries.withIndex()) {
            if (A[q[1]] % 2 == 0) initial -= A[q[1]]
            A[q[1]] += q[0]
            if (A[q[1]] % 2 == 0) initial += A[q[1]]
            rst[i] = initial
        }

        return rst
    }
}