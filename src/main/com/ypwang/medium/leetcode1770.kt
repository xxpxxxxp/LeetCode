package com.ypwang.medium

class Solution1770 {
    fun maximumScore(nums: IntArray, multipliers: IntArray): Int {
        val cache = Array(multipliers.size+1) { IntArray(multipliers.size+1) { Int.MIN_VALUE } }

        fun calc(left: Int, right: Int): Int {
            if (left == 0 && right == 0)
                return 0

            if (cache[left][right] == Int.MIN_VALUE) {
                if (left > 0) {
                    cache[left][right] = maxOf(cache[left][right], calc(left-1, right) + nums[left-1] * multipliers[left + right - 1])
                }

                if (right > 0) {
                    cache[left][right] = maxOf(cache[left][right], calc(left, right-1) + nums[nums.size-right] * multipliers[left + right - 1])
                }
            }

            return cache[left][right]
        }

        return multipliers.indices.map { calc(it, multipliers.size - it) }.max()!!
    }
}

fun main() {
    println(Solution1770().maximumScore(intArrayOf(1,2,3), intArrayOf(3,2,1)))
    println(Solution1770().maximumScore(intArrayOf(-5,-3,-3,-2,7,1), intArrayOf(-10,-5,3,4,6)))
}