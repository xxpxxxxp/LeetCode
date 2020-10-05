package com.ypwang.easy

class Solution1608 {
    fun specialArray(nums: IntArray): Int {
        var l = 0
        var r = nums.size

        while (l < r) {
            val mid = (l + r) / 2
            val count = nums.count { it >= mid }

            if (mid < count) l = mid + 1
            else r = mid
        }

        return if (nums.count { it >= l } == l) l else -1
    }
}