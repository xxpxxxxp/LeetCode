package com.ypwang.medium

class Solution2216 {
    fun minDeletion(nums: IntArray): Int {
        var deletion = 0
        var i = 0
        while (i < nums.size) {
            val newIndex = i - deletion
            if (newIndex % 2 == 0 && i < nums.lastIndex && nums[i] == nums[i + 1])
                deletion++
            else
                i++
        }
        return if ((nums.size - deletion) % 2 == 0) deletion else deletion + 1
    }
}