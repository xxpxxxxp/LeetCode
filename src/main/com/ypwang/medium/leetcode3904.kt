package com.ypwang.medium

class Solution3904 {
    fun firstStableIndex(nums: IntArray, k: Int): Int {
        val n = nums.size
        val mini = IntArray(n)

        // Suffix min
        mini[n - 1] = nums[n - 1]
        for (i in n - 2 downTo 0) {
            mini[i] = minOf(mini[i + 1], nums[i])
        }

        // Find index
        var maxi = nums[0]
        for (i in 0 until n) {
            maxi = maxOf(maxi, nums[i])
            if (maxi - mini[i] <= k)
                return i
        }

        return -1
    }
}
