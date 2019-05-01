package com.ypwang.medium

class Solution560 {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val start = mutableMapOf(0 to 1)

        var sum = 0
        var count = 0
        for (num in nums) {
            sum += num
            if ((sum - k) in start)
                count += start[(sum - k)]!!

            start[sum] = start.getOrDefault(sum, 0) + 1
        }

        return count
    }
}

fun main() {
    println(Solution560().subarraySum(intArrayOf(1,1,1), 2))
}