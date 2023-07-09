package com.ypwang.easy

class Solution2765 {
    fun alternatingSubarray(nums: IntArray): Int {
        val n = nums.size
        var res = 0
        var j = 0
        for (i in 0 until n) {
            j = i + 1
            while (j < n && nums[j] == nums[i] + (j - i) % 2) {
                res = maxOf(res, (j - i + 1))
                ++j
            }
        }
        return if (res > 1) res else -1
    }
}

fun main() {
    println(Solution2765().alternatingSubarray(intArrayOf(14, 30, 29, 49, 3, 23, 44, 21, 26, 52)))
}