package com.ypwang.hard

class Solution330 {
    fun minPatches(nums: IntArray, n: Int): Int {
        var end = 1L     // exclusive
        var count = 0
        var idx = 0
        while (end <= n) {
            if (idx == nums.size || nums[idx] > end) {
                count++
                end += end
            } else {
                while (idx != nums.size && nums[idx] <= end) {
                    end += nums[idx]
                    idx++
                }
            }
        }

        return count
    }
}

fun main() {
    println(Solution330().minPatches(intArrayOf(1,3), 6))
    println(Solution330().minPatches(intArrayOf(1,5,10), 20))
    println(Solution330().minPatches(intArrayOf(1,2,2), 5))
}