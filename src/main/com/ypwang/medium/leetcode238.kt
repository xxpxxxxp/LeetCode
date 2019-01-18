package com.ypwang.medium

class Solution238 {
    fun productExceptSelf(nums: IntArray): IntArray {
        val output = IntArray(nums.size){1}

        for (i in 1 until nums.size) {
            output[i] = output[i-1] * nums[i-1]
        }

        var p = 1
        for (i in nums.lastIndex-1 downTo 0) {
            p *= nums[i+1]
            output[i] *= p
        }

        return output
    }
}

fun main(args: Array<String>) {
    println(Solution238().productExceptSelf(intArrayOf(1,2,3,4)).toList())
}