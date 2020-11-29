package com.ypwang.medium

class Solution33 {
    fun search(nums: IntArray, target: Int): Int {
        if (nums.isEmpty())
            return -1

        var l = 0
        var r = nums.lastIndex

        while (l < r) {
            val mid = (r - l) / 2 + l

            if (nums[mid] == target)
                return mid

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

        return if (nums[l] == target) l else -1
    }
}

fun main() {
    println(Solution33().search(intArrayOf(4,5,6,7,0,1,2), 0))
}