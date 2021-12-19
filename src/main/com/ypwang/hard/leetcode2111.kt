package com.ypwang.hard

class Solution2111 {
    private fun binarySearch(x: Int, arr: IntArray, e: Int): Int {
        var l = 0
        var r = e
        while (l < r) {
            val mid = (l + r) / 2
            if (arr[mid] <= x)
                l = mid + 1
            else
                r = mid
        }

        return l
    }

    private fun longestNonDecreasingSequence(nums: IntArray): Int {
        val dp = IntArray(nums.size)
        var len = 0
        for (num in nums) {
            val i = binarySearch(num, dp, len)
            dp[i] = num
            if (i == len) {
                len++
            }
        }
        return nums.size - len
    }

    fun kIncreasing(arr: IntArray, k: Int): Int =
        (0 until k)
            .map { it until arr.size step k }
            .map { it.map { i -> arr[i] } }
            .map { longestNonDecreasingSequence(it.toIntArray()) }
            .sum()
}

fun main() {
    println(Solution2111().kIncreasing(intArrayOf(2,2,2,2,2,1,1,4,4,3,3,3,3,3), 1))
    println(Solution2111().kIncreasing(intArrayOf(4,1,5,2,6,2), 2))
}