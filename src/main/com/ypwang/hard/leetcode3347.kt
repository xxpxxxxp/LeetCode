package com.ypwang.hard

class Solution3347 {
    private fun bisectLeft(nums: IntArray, k: Int): Int {
        var i = 0
        var j = nums.size - 1
        while (i < j) {
            val m = (i + j) / 2
            if (nums[m] < k)
                i = m + 1
            else
                j = m
        }
        return i
    }

    private fun bisectRight(nums: IntArray, k: Int): Int {
        var i = 0
        var j = nums.size - 1
        while (i < j) {
            val m = (i + j + 1) / 2
            if (nums[m] > k)
                j = m - 1
            else
                i = m
        }
        return i
    }

    fun maxFrequency(nums: IntArray, k: Int, numOperations: Int): Int {
        nums.sort()  // Sorting the array

        // Counting frequency using a mutable map
        val ctr = nums.groupBy { it }.map { it.key to it.value.size }.toMap()

        // Set to store the possible values to check for frequency
        val s = mutableSetOf<Int>()
        for (e in nums) {
            s.add(e)
            s.add(e - k)
            s.add(e + k)
        }

        var rst = 0
        for (e in s) {
            // Binary search for range between (e - k) and (e + k)
            val left = bisectLeft(nums, e-k).coerceAtLeast(0)
            val right = bisectRight(nums, e+k).coerceAtMost(nums.size - 1)

            // Count how many numbers are within this range
            val operationsNeeded = right - left + 1 - ctr.getOrDefault(e, 0)

            // Find the maximum frequency achievable with the allowed operations
            rst = maxOf(rst, ctr.getOrDefault(e, 0) + minOf(operationsNeeded, numOperations))
        }

        return rst
    }
}

fun main() {
    println(
        Solution3347().maxFrequency(
            intArrayOf(
                37,42,98,84,19,78,28,84,7,67,90,7,76,64,18,36,69,61,7,44
            ), 6, 17
        )
    )
    println(
        Solution3347().maxFrequency(
            intArrayOf(
                21, 17, 42, 88, 87, 80, 49, 28, 69, 63, 31, 73, 42, 62, 66, 40, 12, 62, 35, 4
            ), 0, 4
        )
    )
}
