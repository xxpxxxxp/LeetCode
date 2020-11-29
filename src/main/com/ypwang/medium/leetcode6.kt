package com.ypwang.medium

class Solution6 {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) {
            return s
        }

        val rst = Array(numRows) { mutableListOf<Char>() }

        var dim = 0
        var line = 0

        for (c in s) {
            rst[line].add(c)

            when (dim) {
                0 -> {
                    if (line == numRows - 1) {
                        dim = 1
                        line--
                    } else {
                        line++
                    }
                }
                1 -> {
                    if (line == 0) {
                        dim = 0
                        line++
                    } else {
                        line--
                    }
                }
            }
        }

        return rst.flatMap { it }.toCharArray().joinToString("")
    }
}

fun main() {
    println(Solution6().convert("PAYPALISHIRING", 1))
}