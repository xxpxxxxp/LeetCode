package com.ypwang.medium

class Solution1540 {
    fun canConvertString(s: String, t: String, k: Int): Boolean {
        if (s.length != t.length)
            return false

        val hoop = IntArray(26){ (k - it + 26) / 26 }

        for ((i, j) in s.zip(t)) {
            if (i != j) {
                val diff = ((j + 26) - i) % 26
                if (hoop[diff] == 0)
                    return false

                hoop[diff]--
            }
        }

        return true
    }
}

fun main() {
    println(Solution1540().canConvertString("input", "ouput", 9))
    println(Solution1540().canConvertString("abc", "bcd", 10))
    println(Solution1540().canConvertString("aab", "bbb", 27))
}