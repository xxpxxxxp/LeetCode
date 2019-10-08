package com.ypwang.medium

class Solution1191 {
    private fun maxSubArray(arr: IntArray, k: Int): Long {
        var max = 0L
        var sum = 0L

        for (i in 0 until arr.size * k) {
            sum += arr[i % arr.size]
            max = maxOf(max, sum)

            if (sum < 0) sum = 0
        }

        return max
    }

    private val mod = 1000000007

    fun kConcatenationMaxSum(arr: IntArray, k: Int): Int {
        if (k == 1) return (maxSubArray(arr, 1) % mod).toInt()
        val max2 = maxSubArray(arr, 2)
        val sum = arr.map { it.toLong() }.sum()
        if (sum < 0) return (max2 % mod).toInt()

        var total = sum * k
        var min = Long.MAX_VALUE
        var curSum = 0L
        for (v in arr) {
            curSum += v
            min = minOf(min, curSum)
        }

        if (min < 0) total -= min

        min = Long.MAX_VALUE
        curSum = 0L
        for (i in arr.lastIndex downTo 0) {
            curSum += arr[i]
            min = minOf(min, curSum)
        }

        if (min < 0) total -= min
        return (maxOf(max2, total) % mod).toInt()
    }
}

fun main() {
    println(Solution1191().kConcatenationMaxSum(intArrayOf(1,-1), 1))
}