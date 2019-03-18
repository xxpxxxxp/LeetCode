package com.ypwang.medium

class Solution34 {
    fun searchLeft(nums: IntArray, target: Int): Int {
        var i = 0
        var j = nums.lastIndex

        while (i < j) {
            val mid = (i + j) / 2
            when {
                nums[mid] >= target -> j = mid
                else -> i = mid + 1
            }
        }

        return if (nums[i] == target) i else -1
    }

    fun searchRight(nums: IntArray, target: Int): Int {
        var i = 0
        var j = nums.lastIndex

        while (i < j) {
            val mid = (i + j + 1) / 2
            when {
                nums[mid] <= target -> i = mid
                else -> j = mid - 1
            }
        }

        return if (nums[i] == target) i else -1
    }

    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.isEmpty())
            return intArrayOf(-1, -1)

        return intArrayOf(searchLeft(nums, target), searchRight(nums, target))
    }
}

fun main(args: Array<String>) {
    println(Solution34().searchRange(intArrayOf(7,10), 8).toList())
}