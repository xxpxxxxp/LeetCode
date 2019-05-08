package com.ypwang.easy

import kotlin.math.abs

class Solution977 {
    fun sortedSquares(A: IntArray): IntArray {
        var i = 0
        while (i + 1 < A.size) {
            if (abs(A[i]) < abs(A[i+1])) break
            i++
        }

        var f = i - 1
        var p  = i
        var idx = 0
        val rst = IntArray(A.size)

        while (f >= 0 && p < A.size) {
            if (abs(A[f]) < abs(A[p])) {
                rst[idx++] = A[f] * A[f]
                f--
            } else {
                rst[idx++] = A[p] * A[p]
                p++
            }
        }

        while (f >= 0) {
            rst[idx++] = A[f] * A[f]
            f--
        }

        while (p < A.size) {
            rst[idx++] = A[p] * A[p]
            p++
        }

        return rst
    }
}

fun main() {
    println(Solution977().sortedSquares(intArrayOf(-4,-1,0,3,10)).toList())
    println(Solution977().sortedSquares(intArrayOf(-7,-3,2,3,11)).toList())
}