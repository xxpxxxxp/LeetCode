package com.ypwang.medium

class Solution978 {
    fun maxTurbulenceSize(A: IntArray): Int {
        if (A.isEmpty())
            return 0

        var max = 1

        var increase = 1
        var decrease = 1

        for (i in 1 until A.size) {
            when {
                A[i] > A[i-1] -> {
                    increase = decrease + 1
                    decrease = 1
                    max = maxOf(max, increase)
                }
                A[i] < A[i-1] -> {
                    decrease = increase + 1
                    increase = 1
                    max = maxOf(max, decrease)
                }
                else -> {
                    decrease = 1
                    increase = 1
                }
            }
        }
        return max
    }
}

fun main() {
    println(Solution978().maxTurbulenceSize(intArrayOf(4,8,12,16)))
}