package com.ypwang.medium

class Solution984 {
    fun strWithout3a3b(A: Int, B: Int): String {
        val sb = StringBuilder()
        var a = A
        var b = B

        while (a > 0 && b > 0) {
            if (a > b) {
                sb.append("aab")
                a -= 2
                b -= 1
            } else if (b > a) {
                sb.append("bba")
                a -= 1
                b -= 2
            } else {
                sb.append("ab")
                a -= 1
                b -= 1
            }
        }

        if (a > 0) (0 until a).forEach{ _ -> sb.append('a') }
        if (b > 0) (0 until b).forEach{ _ -> sb.append('b') }

        return sb.toString()
    }
}

fun main() {
    println(Solution984().strWithout3a3b(2, 2))
}