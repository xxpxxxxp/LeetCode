package com.ypwang.medium

class Solution1664 {
    fun waysToMakeFair(nums: IntArray): Int {
        val total = intArrayOf(0, 0)
        for ((i, c) in nums.withIndex()) {
            total[i % 2] += c
        }

        var rst = 0
        val cur = intArrayOf(0, 0)
        for ((i, c) in nums.withIndex()) {
            total[i % 2] -= c

            if (cur[0] + total[1] == cur[1] + total[0])
                rst++

            cur[i % 2] += c
        }

        return rst
    }
}

fun main() {
    println(Solution1664().waysToMakeFair(intArrayOf(2,1,6,4)))
    println(Solution1664().waysToMakeFair(intArrayOf(1,1,1)))
    println(Solution1664().waysToMakeFair(intArrayOf(1,2,3)))
}