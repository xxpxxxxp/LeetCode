package com.ypwang.medium

import java.lang.StringBuilder

class Solution12 {
    fun intToRoman(num: Int): String {
        var cur = num
        return StringBuilder().apply {
            for (i in 0 until cur/1000) {
                append('M')
            }
            cur %= 1000

            when {
                cur >= 900 -> {
                    append("CM")
                    cur -= 900
                }
                cur >= 500 -> {
                    append("D")
                    cur -= 500
                }
                cur >= 400 -> {
                    append("CD")
                    cur -= 400
                }
            }

            for (i in 0 until cur/100) {
                append('C')
            }
            cur %= 100

            when {
                cur >= 90 -> {
                    append("XC")
                    cur -= 90
                }
                cur >= 50 -> {
                    append("L")
                    cur -= 50
                }
                cur >= 40 -> {
                    append("XL")
                    cur -= 40
                }
            }

            for (i in 0 until cur/10) {
                append('X')
            }
            cur %= 10

            when {
                cur >= 9 -> {
                    append("IX")
                    cur -= 9
                }
                cur >= 5 -> {
                    append("V")
                    cur -= 5
                }
                cur >= 4 -> {
                    append("IV")
                    cur -= 4
                }
            }

            for (i in 0 until cur) {
                append('I')
            }
        }.toString()
    }
}

fun main(args: Array<String>) {
    println(Solution12().intToRoman(1994))
}