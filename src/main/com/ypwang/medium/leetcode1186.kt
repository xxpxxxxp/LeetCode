package com.ypwang.medium

class Solution1186 {
    fun maximumSum(arr: IntArray): Int {
        val dp = Array(arr.size){ IntArray(2) }
        dp[0][0] = arr[0]
        dp[0][1] = 0
        var max = arr[0]
        for (i in 1 until arr.size) {
            // no delete
            dp[i][0] = maxOf(dp[i-1][0] + arr[i], arr[i])
            dp[i][1] = maxOf(dp[i-1][0], dp[i-1][1] + arr[i])
            max = maxOf(max, dp[i][0], dp[i][1])
        }

        return max
    }
}

fun main() {
    println(Solution1186().maximumSum(intArrayOf(1,-2,0,3)))
    println(Solution1186().maximumSum(intArrayOf(1,-2,-2,3)))
    println(Solution1186().maximumSum(intArrayOf(-1,-1,-1,-1)))
}