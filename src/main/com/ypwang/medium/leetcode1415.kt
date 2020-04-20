package com.ypwang.medium

import java.lang.StringBuilder

class Solution1415 {
    fun getHappyString(n: Int, k: Int): String {
        // count of possibles, first char abc, then [ab, bc, ac]
        var all = 3 * Math.pow(2.0, (n-1).toDouble()).toInt()
        if (k > all) return ""

        val possible = listOf('a', 'b', 'c')
        val sb = StringBuilder()
        var pre = '_'
        var rec = k - 1
        while (sb.length < n) {
            val knockout = possible.filter { it != pre }
            all /= knockout.size
            pre = knockout[rec / all]
            sb.append(pre)
            rec %= all
        }

        return sb.toString()
    }
}

fun main() {
    println(Solution1415().getHappyString(1, 3))
    println(Solution1415().getHappyString(1, 4))
    println(Solution1415().getHappyString(3, 9))
    println(Solution1415().getHappyString(10, 100))
}