package com.ypwang.medium

class Solution1567 {
    fun getMaxLen(nums: IntArray): Int {
        var start = 0
        var end = 0
        var len = Int.MIN_VALUE

        var positive = true
        var firstNegative = Int.MAX_VALUE
        var lastNegative = Int.MIN_VALUE
        while (end < nums.size) {
            when {
                nums[end] == 0 -> {
                    len = if (positive)
                        maxOf(len, end - start)
                    else
                    // exclude [start, firstNegative], or [lastNegative, end)
                        maxOf(len, end - 1 - firstNegative, lastNegative - start)

                    start = end+1
                    positive = true
                    firstNegative = Int.MAX_VALUE
                    lastNegative = Int.MIN_VALUE
                }
                nums[end] < 0 -> {
                    positive = !positive
                    firstNegative = minOf(firstNegative, end)
                    lastNegative = maxOf(lastNegative, end)
                }
            }

            end++
        }

        len = if (positive)
            maxOf(len, end - start)
        else
        // exclude [start, firstNegative], or [lastNegative, end)
            maxOf(len, end - 1 - firstNegative, lastNegative - start)

        return len
    }
}

fun main() {
    println(Solution1567().getMaxLen(intArrayOf(5,-20,-20,-39,-5,0,0,0,36,-32,0,-7,-10,-7,21,20,-12,-34,26,2)))
    println(Solution1567().getMaxLen(intArrayOf(-1,2)))
    println(Solution1567().getMaxLen(intArrayOf(-1,-2,-3,0,1)))
    println(Solution1567().getMaxLen(intArrayOf(1,-2,-3,4)))
    println(Solution1567().getMaxLen(intArrayOf(0,1,-2,-3,-4)))
    println(Solution1567().getMaxLen(intArrayOf(1,2,3,5,-6,4,0,10)))
}