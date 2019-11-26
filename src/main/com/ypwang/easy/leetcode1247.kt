package com.ypwang.easy

class Solution1247 {
    fun minimumSwap(s1: String, s2: String): Int {
        var cx = 0
        var cy = 0
        var cnt = 0
        for (i in s1.indices) {
            if (s1[i] == s2[i]) continue
            if (s1[i] == 'x') {
                if (cx == 1) cnt++
                cx = cx xor 1
            }
            else {
                if (cy == 1) cnt++
                cy = cy xor 1
            }
        }

        return when ((cx shl 1) or cy) {
            0 -> cnt
            3 -> cnt + 2
            else -> -1
        }
    }
}

fun main() {
    println(Solution1247().minimumSwap("xx", "yy"))
    println(Solution1247().minimumSwap("xy", "yx"))
    println(Solution1247().minimumSwap("xx", "xy"))
    println(Solution1247().minimumSwap("xxyyxyxyxx", "xyyxyxxxyx"))
}