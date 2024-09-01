package com.ypwang.easy

class Solution3270 {
    fun helper(n: Int, m: Int): Int {
        return (n % (m * 10)) / m
    }

    fun generateKey(num1: Int, num2: Int, num3: Int): Int {
        var k = 0
        var mod = 1
        for (i in 0 until 4) {
            k += minOf(helper(num1, mod), helper(num2, mod), helper(num3, mod)) * mod
            mod *= 10
        }

        return k
    }
}
