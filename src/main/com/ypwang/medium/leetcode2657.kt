package com.ypwang.medium

class Solution2657 {
    fun findThePrefixCommonArray(A: IntArray, B: IntArray): IntArray {
        val seenA = BooleanArray(A.size + 1)
        val seenB = BooleanArray(A.size + 1)
        val rst = IntArray(A.size)
        for (i in rst.indices) {
            var r = 0
            if (seenB[A[i]])
                r++
            if (seenA[B[i]])
                r++
            if (A[i] == B[i])
                r++
            seenA[A[i]] = true
            seenB[B[i]] = true

            if (i > 0)
                r += rst[i-1]
            rst[i] = r
        }
        return rst
    }
}