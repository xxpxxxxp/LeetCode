package com.ypwang.medium

class Solution1438 {
    fun longestSubarray(nums: IntArray, limit: Int): Int {
        val maxQueue = mutableListOf<Int>()
        val minQueue = mutableListOf<Int>()

        var i = 0
        var j = 0
        var max = 0
        while (j < nums.size) {
            while (j < nums.size && (maxQueue.isEmpty() || nums[maxQueue.first()] - nums[minQueue.first()] <= limit)) {
                while (maxQueue.isNotEmpty() && nums[maxQueue.last()] < nums[j])
                    maxQueue.removeAt(maxQueue.lastIndex)

                maxQueue.add(j)

                while (minQueue.isNotEmpty() && nums[minQueue.last()] > nums[j])
                    minQueue.removeAt(minQueue.lastIndex)

                minQueue.add(j)

                j++
            }

            var len = j - i
            if (nums[maxQueue.first()] - nums[minQueue.first()] > limit) len--
            max = maxOf(max, len)

            // catch i up
            while (maxQueue.isNotEmpty() && nums[maxQueue.first()] - nums[minQueue.first()] > limit) {
                if (maxQueue.first() == i) maxQueue.removeAt(0)
                if (minQueue.first() == i) minQueue.removeAt(0)
                i++
            }
        }

        return max
    }
}

fun main() {
    println(Solution1438().longestSubarray(intArrayOf(8,2,4,7), 4))
    println(Solution1438().longestSubarray(intArrayOf(10,1,2,4,7,2), 5))
    println(Solution1438().longestSubarray(intArrayOf(4,2,2,2,4,4,2,2), 0))
}