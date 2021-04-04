package com.ypwang.medium

class Solution1818 {
    fun minAbsoluteSumDiff(nums1: IntArray, nums2: IntArray): Int {
        val s = nums1.sorted().toTypedArray()
        var rst = 0L
        var gain = 0L

        for (i in nums1.indices) {
            val diff = Math.abs(nums1[i] - nums2[i])
            rst += diff

            if (gain < diff) {
                val closest = s.binarySearch(nums2[i]).let { if (it < 0) -it-1 else it }
                if (closest < nums1.size)
                    gain = maxOf(gain, diff - Math.abs(s[closest] - nums2[i]).toLong())

                if (closest > 0)
                    gain = maxOf(gain, diff - Math.abs(s[closest-1] - nums2[i]).toLong())
            }
        }

        return ((rst - gain) % 1000000007).toInt()
    }
}

fun main() {
    println(Solution1818().minAbsoluteSumDiff(intArrayOf(1,7,5), intArrayOf(2,3,5)))
}