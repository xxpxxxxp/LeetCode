package com.ypwang.medium

class Solution1712 {
    fun waysToSplit(nums: IntArray): Int {
        val preSum = IntArray(nums.size + 1)
        for (i in nums.indices) {
            preSum[i+1] = preSum[i] + nums[i]
        }

        var rst = 0L
        var leftBreak = 1
        var minRight = 1
        var maxRight = 1

        do {
            val left = preSum[leftBreak] - preSum[0]
            minRight = maxOf(minRight, leftBreak + 1)
            while (minRight < preSum.lastIndex && preSum[minRight] - preSum[leftBreak] < left)
                minRight++

            maxRight = maxOf(maxRight, leftBreak+1)
            while (maxRight < preSum.lastIndex && preSum.last() - preSum[maxRight] >= preSum[maxRight] - preSum[leftBreak])
                maxRight++

            rst += maxOf(0, maxRight - minRight)
            leftBreak++
        } while (leftBreak < preSum.size)

        return (rst % 1000000007).toInt()
    }
}

fun main() {
    println(Solution1712().waysToSplit(IntArray(100000)))
    println(Solution1712().waysToSplit(intArrayOf(1,2,2,2,5,0)))
    println(Solution1712().waysToSplit(intArrayOf(1,1,1)))
    println(Solution1712().waysToSplit(intArrayOf(3,2,1)))
}