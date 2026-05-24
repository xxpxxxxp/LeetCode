package com.ypwang.medium

class Solution3942 {
    fun minOperations(nums: IntArray): Int {
        val n = nums.size
        if (n == 1)
            return 0

        var ind = -1
        for (i in 0 until n) {
            if (nums[i] == 0) {
                ind = i
                break
            }
        }

        var front = true
        var back = true
        for (i in 1 until n) {
            if (nums[(ind + i) % n] != i) {
                front = false
                break
            }
        }
        for (i in 1 until n) {
            if (nums[(ind - i + n) % n] != i) {
                back = false
                break
            }
        }

        if (!front && !back)
            return -1

        var res = Int.MAX_VALUE
        if (front) {
            res = if (ind == 0)
                0
            else
                minOf(res, ind, n - ind + 2)
        }

        if (back)
            res = minOf(res, n - ind, ind + 2)

        return res
    }
}
