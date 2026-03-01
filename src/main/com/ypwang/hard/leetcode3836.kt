package com.ypwang.hard

class Solution3836 {
    fun maxScore(nums1: IntArray, nums2: IntArray, k: Int): Long {
        val n = nums1.size
        val m = nums2.size
        if (n < m)
            return maxScore(nums2, nums1, k)

        val negINF = -1000000000000000L
        var next = Array(m + 1) { LongArray(k + 1) { negINF } }


        for (j in 0..m)
            next[j][0] = 0

        for (i in n - 1 downTo 0) {
            var curr = Array(m + 1) { LongArray(k + 1) { negINF } }
            for (j in 0..m)
                curr[j][0] = 0

            for (j in m - 1 downTo 0)
                for (p in 1..k)
                    curr[j][p] = maxOf(nums1[i].toLong() * nums2[j] + next[j + 1][p - 1], next[j + 1][p], next[j][p], curr[j + 1][p])

            next = curr
        }

        return next[0][k]
    }
}
