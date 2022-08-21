package com.ypwang.medium

class Solution2381 {
    fun shiftingLetters(s: String, shifts: Array<IntArray>): String {
        val acc = IntArray(s.length)
        for ((ss, e, b) in shifts) {
            val c = if (b == 1) 1 else -1
            acc[ss] += c
            if (e + 1 in s.indices)
                acc[e+1] -= c
        }

        val rst = Array(s.length){' '}
        var c = 0
        for ((i, d) in acc.withIndex()) {
            c += d
            rst[i] = 'a' + ((s[i] - 'a' + c) % 26 + 26) % 26
        }

        return rst.joinToString("")
    }
}

fun main() {
    println(Solution2381().shiftingLetters("abc", arrayOf(
        intArrayOf(0,1,0),intArrayOf(1,2,1),intArrayOf(0,2,1)
    )))
}