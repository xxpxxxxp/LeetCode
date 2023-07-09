package com.ypwang.medium

class Solution2771 {
    fun maxNonDecreasingLength(nums1: IntArray, nums2: IntArray): Int {
        var rst = 1
        val len = Array(2) { intArrayOf(0, 0)}
        for ((x, y) in nums1.zip(nums2)) {
            val small = minOf(x, y)
            val large = maxOf(x, y)

            var smallLen = 1
            if (small >= len[1][0])
                smallLen = len[1][1] + 1
            else if (small >= len[0][0])
                smallLen = len[0][1] + 1

            var largeLen = 1
            if (large >= len[1][0])
                largeLen = len[1][1] + 1
            else if (large >= len[0][0])
                largeLen = len[0][1] + 1

            len[0][0] = small
            len[0][1] = smallLen
            len[1][0] = large
            len[1][1] = maxOf(smallLen, largeLen)
            rst = maxOf(rst, len[1][1])
        }

        return rst
    }
}

fun main() {
    println(Solution2771().maxNonDecreasingLength(intArrayOf(1,3,2,1), intArrayOf(2,2,3,4)))
}