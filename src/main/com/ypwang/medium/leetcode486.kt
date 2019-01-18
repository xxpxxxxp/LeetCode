package com.ypwang.medium

class Solution486 {
    fun PredictTheWinner(nums: IntArray): Boolean {
        val rst = Array(nums.size){ IntArray(nums.size){0} }

        for (i in nums.lastIndex downTo 0) {
            for (j in i+1 until nums.size) {
                rst[i][j] = Math.max(nums[i] - rst[i+1][j], nums[j] - rst[i][j-1])
            }
        }

        return rst[0][nums.lastIndex] >= 0
    }
}

fun main(args: Array<String>) {
    println(Solution486().PredictTheWinner(intArrayOf(1,5,2)))
}