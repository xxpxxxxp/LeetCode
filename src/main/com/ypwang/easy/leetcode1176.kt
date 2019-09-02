package com.ypwang.easy

class Solution1176 {
    fun dietPlanPerformance(calories: IntArray, k: Int, lower: Int, upper: Int): Int {
        fun helper(t: Int): Int =
            when {
                t < lower -> -1
                t > upper -> 1
                else -> 0
            }

        var window = calories.take(k).sum()
        var count = helper(window)

        for (i in k until calories.size) {
            window -= calories[i - k]
            window += calories[i]
            count += helper(window)
        }

        return count
    }
}

fun main() {
    println(Solution1176().dietPlanPerformance(intArrayOf(1,2,3,4,5), 1, 3, 3))
    println(Solution1176().dietPlanPerformance(intArrayOf(3,2), 2, 0, 1))
    println(Solution1176().dietPlanPerformance(intArrayOf(6,5,0,0), 2, 1, 5))
}