package com.ypwang.medium

class Solution375 {
    fun getMoneyAmount(n: Int): Int {
        val cache = IntArray(n * n){Int.MAX_VALUE}          // idx: row diff, col money

        for (i in 0 until n) {
            cache[i] = 0
        }

        // represent money with i - 1, eg [1,10] -> idx [0,9]
        for (diff in 1 until n) {                   // diff between range, [1,n-1], because 0 diff should have value 0
            for (i in 0 until (n - diff)) {
                // money range (i+1, i+1+diff)
                val idx = diff * n + i
                for (j in i..i+diff) {
                    val leftIdx = if (j == i) 0 else cache[(j - 1 - i)*n + i]
                    val rightIdx = if (j == i+diff) 0 else cache[(i+diff - j-1) * n + j+1]
                    val value = j+1 + maxOf(leftIdx, rightIdx)
                    if (value < cache[idx]) cache[idx] = value
                }
            }
        }

        return cache[(n-1)*n]       // row 0
    }
}

fun main() {
    println(Solution375().getMoneyAmount(2))
}