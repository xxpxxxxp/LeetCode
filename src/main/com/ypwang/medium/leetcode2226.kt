package com.ypwang.medium

class Solution2226 {
    fun maximumCandies(candies: IntArray, k: Long): Int {
        var left = 0
        var right = (candies.fold(0L) { a, b -> a + b } / k).toInt()

        while (left < right) {
            val mid = (left + right + 1) / 2
            if (candies.fold(0L) { a, b -> a +  b / mid } >= k)
                left = mid
            else
                right = mid - 1
        }
        return left
    }
}

fun main() {
    println(Solution2226().maximumCandies(intArrayOf(5,8,6), 3L))
}