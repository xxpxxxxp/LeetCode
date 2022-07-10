package com.ypwang.medium

class Solution2333 {
    fun minSumSquareDiff(nums1: IntArray, nums2: IntArray, k1: Int, k2: Int): Long {
        val diff = nums1.zip(nums2).map { Math.abs(it.first - it.second) }
        val max = diff.maxOrNull()!!
        val arr = IntArray(max+1)
        diff.forEach { arr[it]++ }

        var k = k1 + k2
        for (i in arr.lastIndex downTo 1) {
            if (arr[i] > 0) {
                val min = minOf(arr[i], k)
                arr[i] -= min
                arr[i-1] += min
                k -= min

                if (k == 0)
                    break
            }
        }

        return arr.withIndex().map { it.index.toLong() * it.index * it.value }.sum()
    }
}