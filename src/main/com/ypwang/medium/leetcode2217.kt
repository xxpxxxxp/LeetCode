package com.ypwang.medium

class Solution2217 {
    fun kthPalindrome(queries: IntArray, intLength: Int): LongArray {
        val odd = intLength % 2 == 1
        val base = (0 until (intLength-1)/2).fold(1){ a, _ -> a * 10 }

        return queries.map {
            val t = base + it - 1
            if (t.toString().length != base.toString().length)
                return@map -1L

            if (odd)
                t.toString().let { s -> s + s.reversed().drop(1) }.toLong()
            else
                t.toString().let { s -> s + s.reversed() }.toLong()
        }.toLongArray()
    }
}