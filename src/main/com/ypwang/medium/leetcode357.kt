package com.ypwang.medium

class Solution357 {
    fun countNumbersWithUniqueDigits(n: Int): Int {
        fun helper(t: Int): Int {
            return when (t) {
                1 -> 10
                else -> {
                    9 * ((1..(t-1)).map { 10 - it }.reduce{ a, b -> a*b })
                }
            }
        }

        return if (n == 0) 1 else (1..n).map {
            val tmp = helper(it)
            println(tmp)
            tmp
             }.sum()
    }
}

fun main() {
    println(Solution357().countNumbersWithUniqueDigits(2))
}