package com.ypwang.medium

class Solution795 {
    fun numSubarrayBoundedMax(A: IntArray, L: Int, R: Int): Int {
        var sum = 0
        var cliff = -1
        var platform = -1

        for ((i, a) in A.withIndex()) {
            when {
                a in L..R -> {
                    // a is platform
                    platform = i
                    sum += i - cliff
                }
                a > R -> {
                    // a is cliff
                    cliff = i
                }
                else -> {
                    // a is valley
                    if (platform > cliff) {
                        sum += platform - cliff
                    }
                }
            }
        }

        return sum
    }
}

fun main() {
    println(Solution795().numSubarrayBoundedMax(intArrayOf(73,55,36,5,55,14,9,7,72,52), 32, 69))
}