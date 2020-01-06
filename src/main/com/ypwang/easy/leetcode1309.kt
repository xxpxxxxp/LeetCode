package com.ypwang.easy

import java.lang.StringBuilder

class Solution1309 {
    fun freqAlphabets(s: String): String {
        val sb = StringBuilder()

        var idx = s.lastIndex
        while (idx >= 0) {
            when (s[idx]) {
                '#' -> {
                    assert(idx > 1)
                    val v = s.substring(idx-2, idx).toInt()
                    sb.append('j' + v - 10)
                    idx -= 3
                }
                else -> {
                    sb.append('a' + (s[idx] - '1'))
                    idx--
                }
            }
        }

        return sb.toString().reversed()
    }
}

fun main() {
    println(Solution1309().freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"))
    println(Solution1309().freqAlphabets("1326#"))
}