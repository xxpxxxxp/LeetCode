package com.ypwang.hard

import java.lang.Exception

class Solution440 {
    fun findKthNumber(n: Int, k: Int): Int = findKthNumber(n, k, 0)

    fun findKthNumber(n: Int, k: Int, pre: Int): Int {
        if (k == 1 && pre != 0) return pre      // starting with pre, the first one is itself
        var c = if (pre != 0) k-1 else k    // 0 is not in range
        for (i in 0..9) {
            val next = pre * 10 + i
            val count = eval(next, n)   // starting with pre[i], `count` in range
            if (c <= count) return findKthNumber(n, c, next)
            else c -= count
        }
        throw Exception("na")       // not possible if input valid
    }

    fun eval(start: Int, n: Int): Int {
        if (start == 0) return 0
        var sum = 0
        var mut = 1
        while (start <= n / mut) {
            sum += minOf(mut, n - start * mut + 1)
            mut *= 10
        }
        return sum
    }
}

fun main() {
    println(Solution440().findKthNumber(681692778, 351251360))
    println(Solution440().findKthNumber(100, 90))
    println(Solution440().findKthNumber(1, 1))
    println(Solution440().findKthNumber(13, 2))
    println(Solution440().findKthNumber(156758516, 123456))
}