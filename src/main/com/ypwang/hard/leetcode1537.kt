package com.ypwang.hard

class Solution1537 {
    fun maxSum(nums1: IntArray, nums2: IntArray): Int {
        val mod = 1000000007

        var i = 0
        var j = 0
        var sum1 = 0L
        var sum2 = 0L
        var sum = 0L

        while (i < nums1.size && j < nums2.size) {
            when {
                nums1[i] < nums2[j] ->
                    sum1 += nums1[i++]
                nums1[i] > nums2[j] ->
                    sum2 += nums2[j++]
                else -> {
                    sum += maxOf(sum1, sum2)
                    sum += nums1[i]
                    sum1 = 0L
                    sum2 = 0L
                    i++
                    j++
                }
            }
        }

        while (i < nums1.size)
            sum1 += nums1[i++]

        while (j < nums2.size)
            sum2 += nums2[j++]

        return ((sum + maxOf(sum1, sum2)) % mod).toInt()
    }
}

fun main() {
    println(Solution1537().maxSum(intArrayOf(2,4,5,8,10), intArrayOf(4,6,8,9)))
}