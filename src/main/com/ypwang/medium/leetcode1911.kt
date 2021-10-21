package com.ypwang.medium

class Solution1911 {
    fun maxAlternatingSum(nums: IntArray): Long {
        val cur = longArrayOf(nums.first().toLong(), 0L)   // current max diff of idx [even, odd]

        for (v in nums.drop(1)) {
            val (even, odd) = cur

            cur[0] = maxOf(even, odd + v)
            cur[1] = maxOf(odd, even - v)
        }

        return cur.maxOrNull()!!
    }
}

fun main() {
    println(Solution1911().maxAlternatingSum(intArrayOf(4,2,5,3)))
    println(Solution1911().maxAlternatingSum(intArrayOf(5,6,7,8)))
    println(Solution1911().maxAlternatingSum(intArrayOf(6,2,1,2,4,5)))
}