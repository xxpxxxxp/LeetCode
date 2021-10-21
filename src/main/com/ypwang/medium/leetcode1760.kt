package com.ypwang.medium

class Solution1760 {
    fun minimumSize(nums: IntArray, maxOperations: Int): Int {
        fun judge(i: Int): Int = nums.map { (it + i - 1) / i - 1 }.sum()

        var left = 1
        var right = nums.maxOrNull()!!

        while (left != right) {
            val mid = (left + right) / 2
            if (judge((mid)) <= maxOperations) {
                right = mid
            } else {
                left = mid + 1
            }
        }

        return left
    }
}