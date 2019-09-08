package com.ypwang.hard

class Solution410 {
    fun splitArray(nums: IntArray, m: Int): Int {
        fun canSplit(candidate: Int): Boolean {
            var count = 1
            var sum = 0L
            for (n in nums) {
                if (sum + n <= candidate) {
                    sum += n
                } else {
                    sum = n.toLong()
                    count++
                }
            }

            return count <= m
        }

        var left = nums.max()!!.toLong()
        var right = nums.map { it.toLong() }.sum()

        while (left < right) {
            val mid = (left + right) / 2
            if (canSplit(mid.toInt())) right = mid else left = mid + 1
        }

        return left.toInt()
    }
}

fun main() {
    println(Solution410().splitArray(intArrayOf(1,2147483647), 2))
}