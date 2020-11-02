package com.ypwang.hard

import java.lang.StringBuilder

class Solution1643 {
    private fun C(i: Int, j: Int): Int {
        var rst = 1
        var mul = j-i+1
        var mod = 2
        while (mul <= j) {
            rst *= mul
            mul++
            while (mod <= i && rst % mod == 0) {
                rst /= mod
                mod++
            }
        }

        return rst
    }

    fun kthSmallestPath(destination: IntArray, k: Int): String {
        var h = destination[1]
        var v = destination[0]

        var kc = k
        val sb = StringBuilder()

        while (kc > 0) {
            if (h == 0 || v == 0)
                break

            val c = C(minOf(h-1, v), h+v-1)
            if (c >= kc) {
                sb.append('H')
                h--
            } else {
                sb.append('V')
                v--
                kc -= c
            }
        }

        repeat(h) { sb.append('H') }
        repeat(v) { sb.append('V') }
        return sb.toString()
    }
}

fun main() {
    println(Solution1643().kthSmallestPath(intArrayOf(2,3),1))
    println(Solution1643().kthSmallestPath(intArrayOf(2,3),2))
    println(Solution1643().kthSmallestPath(intArrayOf(2,3),3))
}