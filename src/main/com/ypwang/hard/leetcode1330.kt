package com.ypwang.hard

class Solution1330 {
    fun maxValueAfterReverse(nums: IntArray): Int {
        var mx = Int.MIN_VALUE
        var mi = Int.MAX_VALUE

        for (i in 1 until nums.size) {
            mx = maxOf(mx, minOf(nums[i-1], nums[i]))
            mi = minOf(mi, maxOf(nums[i-1], nums[i]))
        }

        var change = maxOf(0, (mx - mi) * 2)
        var pre = 0

        for (i in 1 until nums.size) {
            pre += Math.abs(nums[i] - nums[i-1])
            change = maxOf(change, Math.abs(nums[0] - nums[i]) - Math.abs(nums[i] - nums[i-1]),
                    Math.abs(nums[i-1] - nums.last()) - Math.abs(nums[i] - nums[i-1]))
        }

        return pre + change
    }
}