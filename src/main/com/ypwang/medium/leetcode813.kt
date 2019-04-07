package com.ypwang.medium

class Solution813 {
    fun largestSumOfAverages(A: IntArray, K: Int): Double {
        val sum = IntArray(A.size + 1){0}
        for (i in 1 .. A.size) {
            sum[i] = sum[i-1] + A[i-1]
        }

        // i: end index, not include; j: partition number
        val cache = Array(A.size * K){-1.0}
        fun index(i: Int, j: Int): Int = i + j * A.size

        for (i in 0 until A.size) {
            cache[index(i, 0)] = sum[i+1].toDouble() / (i + 1)
        }

        for (j in 1 until K) {
            for (i in j until A.size) {
                var min = Double.MIN_VALUE
                for (k in 0 until i) {
                    val cur = cache[index(k, j-1)] + (sum[i+1] - sum[k+1]).toDouble() / (i - k)
                    if (cur > min) {
                        min = cur
                    }
                }
                cache[index(i, j)] = min
            }
        }

        return cache[index(A.lastIndex, K-1)]
    }
}

fun main() {
    println(Solution813().largestSumOfAverages(intArrayOf(9,1,2,3,9), 3))
}