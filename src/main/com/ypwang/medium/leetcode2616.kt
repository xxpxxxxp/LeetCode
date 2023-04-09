package com.ypwang.medium

class Solution2616 {
    fun minimizeMax(nums: IntArray, p: Int): Int {
        nums.sort()
        if (p == 0)
            return 0

        var left = 0
        var right = (1 until nums.size).map { nums[it] - nums[it-1] }.max()!!

        while (left < right) {
            val mid = (left + right) / 2
            var i = 1
            var c = 0
            while (i < nums.size) {
                if (nums[i] - nums[i-1] <= mid) {
                    c++
                    i++
                }
                i++
            }

            if (c >= p)
                right = mid
            else
                left = mid + 1
        }

        return left
    }
}

fun main() {
    println(Solution2616().minimizeMax(intArrayOf(10,1,2,7,1,3), 2))
}