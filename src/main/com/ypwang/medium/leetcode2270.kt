package com.ypwang.medium

class Solution2270 {
    fun waysToSplitArray(nums: IntArray): Int {
        val sum = nums.fold(0L) { a, b -> a + b }
        var cur = 0L
        var rst = 0
        for (i in 0 until nums.lastIndex) {
            cur += nums[i]
            if (2 * cur >= sum)
                rst++
        }

        return rst
    }
}

fun main() {
    println(Solution2270().waysToSplitArray(intArrayOf(2,3,1,0)))
}