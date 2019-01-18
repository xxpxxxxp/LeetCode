package com.ypwang.medium

class Solution287 {
    fun findDuplicate(nums: IntArray): Int {
        var slow = nums[0]
        var fast = nums[0]

        do {
            slow = nums[slow]
            fast = nums[nums[fast]]
        } while (slow != fast)

        var start = nums[0]
        var hit = fast
        while (start != hit) {
            start = nums[start]
            hit = nums[hit]
        }
        return start
    }
}