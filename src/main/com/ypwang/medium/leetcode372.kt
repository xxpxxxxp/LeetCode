package com.ypwang.medium

class Solution372 {
    private fun mod(a: Int, b: Int): Int {
        var t = a
        var mod = 1

        for (i in 0 until 32) {
            if ((1 shl i) and b > 0) {
                mod = mod * t % 1337
            }
            t = t * t % 1337
        }

        return mod
    }

    fun superPow(a: Int, b: IntArray): Int {
        val aa = a % 1337
        var m = 1

        for (bb in b) {
            m = mod(m, 10) * mod(aa, bb) % 1337
        }

        return m
    }
}

fun main() {
    println(Solution372().superPow(2147483647, intArrayOf(2, 0, 0)))
}