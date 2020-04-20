package com.ypwang.medium

class Solution1414 {
    fun findMinFibonacciNumbers(k: Int): Int {
        val fib = mutableListOf(1, 2)
        var a = 1
        var b = 2
        while (b < k) {
            val t = b
            b += a
            fib.add(b)
            a = t
        }

        var count = 0
        var rest = k
        while (rest > 0) {
            val idx = fib.binarySearch(rest).let { if (it < 0) -it-2 else it }
            rest -= fib[idx]
            count++
        }

        return count
    }
}

fun main() {
    println(Solution1414().findMinFibonacciNumbers(19))
}