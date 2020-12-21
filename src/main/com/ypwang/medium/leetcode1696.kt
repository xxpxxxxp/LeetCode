package com.ypwang.medium

class Solution1696 {
    fun maxResult(nums: IntArray, k: Int): Int {
        val slide = mutableListOf(nums.lastIndex to nums.last())

        for (i in nums.size-2 downTo 0) {
            while (slide.last().first - k > i)
                slide.removeAt(slide.lastIndex)

            val sum = nums[i] + slide.last().second
            while (slide.isNotEmpty() && slide.first().second <= sum)
                slide.removeAt(0)

            slide.add(0, i to sum)
        }

        return slide.first().second
    }
}