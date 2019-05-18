package com.ypwang.hard

class Solution128 {
    fun longestConsecutive(nums: IntArray): Int {
        val set = nums.toSet()

        var max = 0
        for (num in set) {
            if (num - 1 in set) continue

            var count = 1
            while (num + count in set) {
                count++
            }

            if (count > max)
                max = count
        }

        return max
    }
}