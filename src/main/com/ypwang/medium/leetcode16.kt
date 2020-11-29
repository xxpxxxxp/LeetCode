package com.ypwang.medium

import kotlin.math.*

class Solution16 {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()

        fun findSum(startIndex: Int, target: Int, pre: Int): Int {
            var closest = Int.MAX_VALUE

            var start = startIndex
            var end = nums.lastIndex

            while (start < end) {
                val startN = nums[start]
                val endN = nums[end]
                val remain = target - pre - startN - endN
                when {
                    remain == 0 -> return 0
                    remain < 0 -> do {
                        end--
                    } while (end >= 0 && nums[end] == endN)
                    remain > 0 -> do {
                        start++
                    } while (start < nums.size && nums[start] == startN)
                }
                if (abs(remain) < abs(closest)) {
                    closest = remain
                }
            }
            return closest
        }

        var closest = Int.MAX_VALUE

        var index = 0
        while (index < nums.size) {
            val num = nums[index]
            val t = findSum(index + 1, target, num)
            if (t == 0)
                return target
            else if (abs(t) < abs(closest))
                closest = t
            do {
                index++
            } while (index < nums.size && nums[index] == num)
        }

        return target - closest
    }
}

fun main() {
    println(Solution16().threeSumClosest(intArrayOf(0,5,-1,-2,4,-1,0,-3,4,-5), 1))
}