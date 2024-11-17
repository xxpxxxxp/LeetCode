package com.ypwang.hard

class Solution3357 {
    fun minDifference(nums: IntArray): Int {
        when (nums.count { it == -1 }) {
            0 -> {
                var maxDiff = 0
                for (i in 0 until nums.size - 1)
                    maxDiff = maxOf(maxDiff, Math.abs(nums[i] - nums[i + 1]))
                return maxDiff
            }
            nums.size ->
                return 0
        }

        var low = 0
        var high = 1000000005

        while (low != high) {
            val mid = (low + high) / 2
            if (isValidDifference(nums.clone(), mid))
                high = mid
            else
                low = mid + 1
        }

        return low
    }

    fun isValidDifference(nums: IntArray, maxDiff: Int): Boolean {
        val lowerBounds = mutableListOf<Int>()
        val upperBounds = mutableListOf<Int>()

        for (i in nums.indices) {
            if (nums[i] != -1 && ((i > 0 && nums[i - 1] == -1) || (i < nums.size - 1 && nums[i + 1] == -1))) {
                lowerBounds.add(nums[i] - maxDiff)
                upperBounds.add(nums[i] + maxDiff)
            }
        }

        val minValue = lowerBounds.min()!! + 2 * maxDiff
        val maxValue = upperBounds.max()!! - 2 * maxDiff

        for (i in nums.indices) {
            if (nums[i] == -1) {
                if (
                    (i == 0 || Math.abs(nums[i - 1] - minValue) <= maxDiff) &&
                    (i == nums.size - 1 || nums[i + 1] == -1 || Math.abs(nums[i + 1] - minValue) <= maxDiff)
                ) {
                    nums[i] = minValue
                } else {
                    nums[i] = maxValue
                }
            }
        }

        for (i in 0 until nums.size - 1) {
            if (Math.abs(nums[i] - nums[i + 1]) > maxDiff)
                return false
        }

        return true
    }
}

fun main() {
    println(Solution3357().minDifference(intArrayOf(1,2,-1,10,8)))
}