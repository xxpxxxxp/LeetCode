package com.ypwang.easy

class NumArray(nums: IntArray) {
    val sums = mutableListOf<Int>()
    init {
        var sum = 0
        for (i in 0 until nums.size) {
            sum += nums[i]
            sums.add(sum)
        }
    }
    fun sumRange(i: Int, j: Int): Int {
        return sums[j] - (if (i > 0) sums[i-1] else 0)
    }
}

fun main(args: Array<String>) {
    val n = NumArray(intArrayOf(-2, 0, 3, -5, 2, -1))
    println(n.sumRange(0, 2))
}