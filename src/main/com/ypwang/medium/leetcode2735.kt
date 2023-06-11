package com.ypwang.medium

class Solution2735 {
    fun minCost(nums: IntArray, x: Int): Long {
        val prices = nums.clone()
        var step = nums.fold(0L) { a, b -> a + b }
        var rst = step

        for (i in 1 until nums.size) {
            step += x
            for (j in nums.indices) {
                if (nums[(i + j) % nums.size] < prices[j]) {
                    step -= prices[j] - nums[(i + j) % nums.size]
                    prices[j] = nums[(i + j) % nums.size]
                }
            }
            rst = minOf(rst, step)
        }

        return rst
    }
}

fun main() {
    println(Solution2735().minCost(intArrayOf(20,1,15), 5))
    println(Solution2735().minCost(intArrayOf(1,2,3), 4))
}