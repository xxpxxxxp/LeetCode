package com.ypwang.medium

class Solution1775 {
    fun minOperations(nums1: IntArray, nums2: IntArray): Int {
        val sum1 = nums1.sum()
        val sum2 = nums2.sum()

        if (sum1 == sum2)
            return 0

        nums1.sort()
        nums2.sort()
        val (n1, n2) = if (sum1 > sum2) nums2 to nums1 else nums1 to nums2
        var diff = Math.abs(sum1 - sum2)
        var count = 0

        var i = 0
        var j = n2.lastIndex
        while (diff != 0) {
            // increase n1
            val increase = 6 - n1[i]
            // or decrease n2
            val decrease = n2[j] - 1

            if (increase == 0 && decrease == 0)
                return -1

            if (increase > decrease) {
                diff -= minOf(diff, increase)
                n1[i] = 6
                if (i < n1.lastIndex)
                    i++
            } else {
                diff -= minOf(diff, decrease)
                n2[j] = 1
                if (j > 0)
                    j--
            }
            count++
        }

        return count
    }
}

fun main() {
    println(Solution1775().minOperations(intArrayOf(1,2,3,4,5,6), intArrayOf(1,1,2,2,2,2)))
    println(Solution1775().minOperations(intArrayOf(1,1,1,1,1,1,1), intArrayOf(6)))
    println(Solution1775().minOperations(intArrayOf(6,6), intArrayOf(1)))
}