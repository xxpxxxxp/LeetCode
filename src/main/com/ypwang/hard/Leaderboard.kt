package com.ypwang.hard

class Solution1246 {
    fun minimumMoves(arr: IntArray): Int {
        val dp = Array(arr.size+1){ IntArray(arr.size+1) }
        for (i in arr.indices) dp[i][i] = 1
        for (diff in 1 until arr.size) {
            for (i in 0 until (arr.size-diff)) {
                var t = 1 + dp[i+1][i+diff]
                if (arr[i] == arr[i+1]) t = minOf(t, 1 + dp[i+2][i+diff])
                for (k in i+2..i+diff) {
                    if (arr[k] == arr[i])
                        t = minOf(t, dp[i+1][k-1] + dp[k+1][i+diff])
                }
                dp[i][i+diff] = t
            }
        }

        return dp[0][arr.lastIndex]
    }
}

fun main() {
    println(Solution1246().minimumMoves(intArrayOf(1,2,3,1)))
    println(Solution1246().minimumMoves(intArrayOf(1,2)))
    println(Solution1246().minimumMoves(intArrayOf(1,3,4,1,5)))
}