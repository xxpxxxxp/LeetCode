package com.ypwang.medium

class Solution3738 {
    fun longestSubarray(nums: IntArray): Int {
        val n = nums.size
        val left = IntArray(n) { 1 }
        val right = IntArray(n) { 1 }
        for (i in 1..<n)
            if (nums[i - 1] <= nums[i]) left[i] = left[i - 1] + 1
        for (i in n - 2 downTo 0)
            if (nums[i] <= nums[i + 1]) right[i] = right[i + 1] + 1
        var res = minOf(n, left.max() + 1)
        for (i in 1..<n - 1)
            if (nums[i - 1] <= nums[i + 1])
                res = maxOf(res, left[i - 1] + 1 + right[i + 1])

        return res
    }
}
