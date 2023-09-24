package com.ypwang.medium

class Solution2856 {
    fun minLengthAfterRemovals(nums: List<Int>): Int {
        var count = 0
        var cur = nums.first()
        val counts = mutableListOf<Int>()

        for (c in nums) {
            if (c != cur) {
                counts.add(count)
                cur = c
                count = 1
            } else
                count++
        }

        counts.add(count)

        val max = counts.max()
        return if (max <= nums.size / 2) nums.size % 2 else 2 * max - nums.size
    }
}

fun main() {
    println(Solution2856().minLengthAfterRemovals(listOf(1,2,3,4)))
}