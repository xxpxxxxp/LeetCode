package com.ypwang.hard

class Solution793 {
    private fun helper(i: Long): Int {
        var cur = i
        var sum = 0L
        while (cur > 0) {
            sum += cur / 5
            cur /= 5
        }

        return sum.toInt()
    }

    fun preimageSizeFZF(K: Int): Int {
        var left = 0L
        var right = 5000000000L

        while (left < right) {
            val mid = left + (right - left) / 2
            if (helper(mid) < K) left = mid + 1
            else right = mid
        }

        val a = left

        left = 0
        right = 5000000000L

        while (left < right) {
            val mid = left + (right - left) / 2
            if (helper(mid) <= K) left = mid + 1
            else right = mid
        }

        return (left - a).toInt()
    }
}

fun main() {
    println(Solution793().preimageSizeFZF(5))
    println(Solution793().preimageSizeFZF(1000000000))
    println(Solution793().preimageSizeFZF(0))
}