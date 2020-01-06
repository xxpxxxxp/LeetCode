package com.ypwang.hard

class Solution1012 {
    fun numDupDigitsAtMostN(N: Int): Int {
        val dup = IntArray(9)
        val noDup = IntArray(9)
        dup[0] = 1
        noDup[0] = 9

        var mul = 10
        for (i in 1 until 9) {
            noDup[i] = noDup[i-1] * (10 - i)
            dup[i] = mul * 9 + dup[i-1] - noDup[i]
            mul *= 10
        }

        return dup[3]
    }
}

fun main() {
    println(Solution1012().numDupDigitsAtMostN(1000))
}