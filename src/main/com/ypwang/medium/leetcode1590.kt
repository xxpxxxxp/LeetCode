package com.ypwang.medium

class Solution1590 {
    fun minSubarray(nums: IntArray, p: Int): Int {
        val diff = nums.fold(0){ acc, j -> (acc % p + j % p) % p }
        if (diff == 0) return 0

        var mod = 0
        val map = mutableMapOf(0 to -1)
        var min = Int.MAX_VALUE

        for ((i, num) in nums.withIndex()) {
            mod = (mod + num) % p

            if (((mod + p - diff) % p) in map)
                min = minOf(min, i - map[(mod + p - diff) % p]!!)

            map[mod] = i
        }

        return if (min == Int.MAX_VALUE || min == nums.size) -1 else min
    }
}

fun main() {
    println(Solution1590().minSubarray(intArrayOf(1), 1))
    println(Solution1590().minSubarray(intArrayOf(3,1,4,2), 6))
    println(Solution1590().minSubarray(intArrayOf(6,3,5,2), 9))
    println(Solution1590().minSubarray(intArrayOf(1,2,3), 3))
    println(Solution1590().minSubarray(intArrayOf(1,2,3), 7))
    println(Solution1590().minSubarray(intArrayOf(1000000000,1000000000,1000000000), 3))
}