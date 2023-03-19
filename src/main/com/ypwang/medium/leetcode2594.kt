package com.ypwang.medium

class Solution2594 {
    fun repairCars(ranks: IntArray, cars: Int): Long {
        var left = 1L
        var right = 1L * ranks[0] * cars * cars
        while (left < right) {
            val mid = (left + right) / 2
            if (ranks.map { Math.sqrt(1.0 * mid / it).toLong() }.sum() < cars)
                left = mid + 1
            else
                right = mid
        }
        return left
    }
}