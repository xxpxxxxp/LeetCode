package com.ypwang.hard

import java.util.*

class Solution1388 {
    fun maxSizeSlices(slices: IntArray): Int {
        val minIdx = slices.indexOf(slices.min()!!)
        val rotated = slices.toMutableList()
        Collections.rotate(rotated, -minIdx)
        val noCircle = rotated.drop(1)

        val dp = Array(noCircle.size) { IntArray(slices.size / 3 + 1) { -1 } }

        // i: slices not passed over yet
        // j: slices need to eat
        fun calc(i: Int, j: Int): Int {
            if (i >= noCircle.size || j == 0) return 0
            if (dp[i][j] == -1) dp[i][j] = maxOf(noCircle[i] + calc(i + 2, j - 1), calc(i + 1, j))
            return dp[i][j]
        }

        return calc(0, slices.size / 3)
    }
}

fun main() {
    println(Solution1388().maxSizeSlices(intArrayOf(9,5,1,7,8,4,4,5,5,8,7,7)))
}