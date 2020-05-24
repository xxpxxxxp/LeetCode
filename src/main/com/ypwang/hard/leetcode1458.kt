package com.ypwang.hard

class Solution1458 {
    fun maxDotProduct(nums1: IntArray, nums2: IntArray): Int {
        val dp = Array(nums1.size + 1) { IntArray(nums2.size + 1) }

        for (i in nums1.indices) {
            for (j in nums2.indices) {
                dp[i+1][j+1] = maxOf(maxOf(nums1[i] * nums2[j], 0) + dp[i][j], dp[i+1][j], dp[i][j+1])
            }
        }

        return dp.last().last().let {
            if (it > 0) it
            else maxOf(nums1.min()!! * nums2.max()!!, nums1.max()!! * nums2.min()!!)
        }
    }
}

fun main() {
    println(Solution1458().maxDotProduct(intArrayOf(2,1,-2,5), intArrayOf(3,0,-6)))
    println(Solution1458().maxDotProduct(intArrayOf(3,-2), intArrayOf(2,-6,7)))
    println(Solution1458().maxDotProduct(intArrayOf(-1,-1), intArrayOf(1,1)))
}