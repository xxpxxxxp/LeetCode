package com.ypwang.easy

import java.lang.Exception

class Solution1317 {
    fun getNoZeroIntegers(n: Int): IntArray {
        for (a in 0..n/2) {
            val b = n - a
            if (!a.toString().contains('0') && !b.toString().contains('0'))
                return intArrayOf(a, b)
        }

        throw Exception("na")
    }
}

fun main() {
    println(Solution1317().getNoZeroIntegers(2).toList())
    println(Solution1317().getNoZeroIntegers(11).toList())
    println(Solution1317().getNoZeroIntegers(10000).toList())
    println(Solution1317().getNoZeroIntegers(69).toList())
    println(Solution1317().getNoZeroIntegers(1010).toList())
}