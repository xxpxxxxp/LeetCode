package com.ypwang.medium

class Solution1658 {
    fun minOperations(nums: IntArray, x: Int): Int {
        val total = nums.sum() - x
        if (total < 0)
            return -1

        var i = 0
        var j = 0
        var max = Int.MIN_VALUE
        var sum = 0

        while (i < nums.size) {
            while (j < nums.size && sum < total) {
                sum += nums[j]
                j++
            }

            if (sum == total) {
                max = maxOf(max, j - i)
            }

            sum -= nums[i++]
        }

        return if (max == Int.MIN_VALUE) -1 else nums.size - max
    }
}

fun main() {
    println(Solution1658().minOperations(intArrayOf(1,1,4,2,3), 5))
    println(Solution1658().minOperations(intArrayOf(5,6,7,8,9), 4))
    println(Solution1658().minOperations(intArrayOf(3,2,20,1,1,3), 10))
}