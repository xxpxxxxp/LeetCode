package com.ypwang.medium

class Solution1695 {
    fun maximumUniqueSubarray(nums: IntArray): Int {
        var i = 0
        var j = 0
        var sum = 0
        var max = Int.MIN_VALUE
        val set = mutableSetOf<Int>()

        while (j < nums.size) {
            while (j < nums.size && nums[j] !in set) {
                set.add(nums[j])
                sum += nums[j]
                max = maxOf(max, sum)
                j++
            }
            if (j != nums.size) {
                while (nums[i] != nums[j]) {
                    set.remove(nums[i])
                    sum -= nums[i]
                    i++
                }
                set.remove(nums[i])
                sum -= nums[i]
                i++
            }
        }

        return max
    }
}