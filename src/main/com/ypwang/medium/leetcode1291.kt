package com.ypwang.medium

class Solution1291 {
    fun generate(bit: Int, start: Int): Int {
        var s = start
        var f = start

        for (i in 1 until bit) {
            s++
            f = f * 10 + s
        }

        return f
    }

    fun sequentialDigits(low: Int, high: Int): List<Int> {
        val l = low.toString().length
        val h = high.toString().length
        val range = low..high

        val rst = mutableListOf<Int>()
        for (i in l..h) {
            for (j in 1..9) {
                if (i + j < 11) {
                    val t = generate(i, j)
                    if (t < low) continue
                    if (t > high) return rst
                    rst.add(t)
                }
            }
        }

        return rst
    }
}