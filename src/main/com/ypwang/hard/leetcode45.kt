package com.ypwang.hard

class Solution45 {
    fun jump(nums: IntArray): Int {
        val dp = IntArray(nums.size){100000}
        dp[dp.lastIndex] = 0
        for (i in nums.lastIndex-1 downTo 0) {
            for (j in 1..nums[i]) {
                if (i+j < nums.size) {
                    dp[i] = minOf(dp[i], 1+dp[i+j])
                }
            }
        }

        return dp.first()
    }
}

fun main() {
    println(Solution45().jump(intArrayOf(2,3,1,1,4)))
}