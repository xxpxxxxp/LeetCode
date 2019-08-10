package com.ypwang.medium

class Solution1144 {
    fun movesToMakeZigzag(nums: IntArray): Int {
        var sumOdd = 0
        for (i in 0 until nums.size step 2) {
            var m = Int.MAX_VALUE
            if (i-1 >= 0) m = minOf(nums[i-1], m)
            if (i+1 < nums.size) m = minOf(nums[i+1], m)

            if (nums[i] >= m) sumOdd += (1 + nums[i] - m)
        }

        var sumEven = 0
        for (i in 1 until nums.size step 2) {
            var m = Int.MAX_VALUE
            if (i-1 >= 0) m = minOf(nums[i-1], m)
            if (i+1 < nums.size) m = minOf(nums[i+1], m)

            if (nums[i] >= m) sumEven += (1 + nums[i] - m)
        }

        return minOf(sumOdd, sumEven)
    }
}

fun main() {
    println(Solution1144().movesToMakeZigzag(intArrayOf(7,4,8,9,7,7,5)))
}