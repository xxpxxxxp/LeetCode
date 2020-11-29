package com.ypwang.medium

class Solution29 {
    fun divide(dividend: Int, divisor: Int): Int {
        if (dividend == 1 shl 31 && divisor == -1) return (1 shl 31) - 1
        var a = Math.abs(dividend)
        val b = Math.abs(divisor)
        var res = 0
        var x: Int

        var lena = 0
        var lenb = 0
        var ta = a
        var tb = b
        while (ta and -1 != 0) {
            ta = ta ushr 1
            lena++
        }
        while (tb and -1 != 0) {
            tb = tb ushr 1
            lenb++
        }

        for (i in lena - lenb downTo 0) {
            if (a - (b shl i) >= 0) {
                res += 1 shl i
                a -= b shl i
            }
        }

        return if (dividend > 0 == divisor > 0) res else -res
    }
}

fun main() {
    println(Solution29().divide(10, 3))
}