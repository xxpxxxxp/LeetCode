package com.ypwang.hard

class Solution233 {
    fun countDigitOne(n: Int): Int {
        if (n <= 0) return 0

        val oc = IntArray(10)
        oc[0] = 0
        var c = 1
        for (i in 1 until oc.size) {
            oc[i] = oc[i-1] * 10 + c
            c *= 10
        }

        var d = 1000000000
        var idx = 9
        while (d > n) {
            d /= 10
            idx--
        }

        var sum = 0
        var cur = n
        // for example 438
        while (d > 0) {
            if (cur >= d) {
                sum += cur / d* oc[idx]            // left most digit [0,1,2,...4), with all possible 1 in lower digit
                sum += minOf(d, cur - d + 1)    // left most digit 1
                cur -= (cur / d) * d               // left most digit fixed at 4, count left (38)
            }
            d /= 10
            idx--
        }

        return sum
    }
}

fun main() {
    println(Solution233().countDigitOne(1410065408))
    println(Solution233().countDigitOne(438))
    println(Solution233().countDigitOne(138))
    println(Solution233().countDigitOne(408))
    println(Solution233().countDigitOne(13))
}