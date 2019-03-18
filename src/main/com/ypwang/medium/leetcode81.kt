package com.ypwang.medium

class Solution81 {
    fun search(nums: IntArray, target: Int): Boolean {
        if (nums.isEmpty())
            return false

        var l = 0
        var r = nums.lastIndex

        while (l < r) {
            val mid = (r - l) / 2 + l

            if (nums[mid] == target)
                return true

            if (nums[l] <= nums[mid]) {
                if (target >= nums[l] && target < nums[mid])
                    r = mid - 1
                else
                    l = mid + 1
            } else {
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1
                } else {
                    r = mid - 1
                }
            }
        }

        return nums[l] == target
    }
}

fun main(args: Array<String>) {
    println(Solution81().search(intArrayOf(1,3,1,1,1), 3))
}