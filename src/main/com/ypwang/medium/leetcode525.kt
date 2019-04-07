package com.ypwang.medium

class Solution525 {
    fun findMaxLength(nums: IntArray): Int {
        var count = 0
        val hash = mutableMapOf(0 to -1)
        var max = 0

        for ((i, num) in nums.withIndex()) {
            when (num) {
                0 -> count++
                1 -> count--
            }
            if (count in hash) {
                max = maxOf(max, i - hash[count]!!)
            } else {
                hash[count] = i
            }
        }

        return max
    }
}

fun main() {
    println(Solution525().findMaxLength(intArrayOf(0,1,0)))
}