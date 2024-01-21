package com.ypwang.hard

class Solution3017 {
    fun countOfPairs(n: Int, x: Int, y: Int): LongArray {
        val (x, y) = minOf(x, y) to maxOf(x, y)
        val rst = LongArray(n)
        for (i in 1..n) {
            rst[0] += 2L // go left and right
            rst[minOf(i - 1, Math.abs(i - y) + x)]-- // reach 1 then stop
            rst[minOf(n - i, Math.abs(i - x) + 1 + n - y)]-- // reach n then stop
            rst[minOf(Math.abs(i - x), Math.abs(y - i) + 1)]++ // reach x then split
            rst[minOf(Math.abs(i - x) + 1, Math.abs(y - i))]++ // reach y then split
            val r = maxOf(x - i, 0) + maxOf(i - y, 0)
            rst[r + (y - x + 0) / 2]-- // i -> x -> y <- x
            rst[r + (y - x + 1) / 2]-- // i -> y -> x <- y
        }
        for (i in 1 until n)
            rst[i] += rst[i - 1]
        return rst
    }
}
