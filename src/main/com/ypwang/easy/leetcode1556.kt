package com.ypwang.easy

class Solution1556 {
    fun thousandSeparator(n: Int): String {
        if (n == 0) return "0"

        val sb = StringBuilder()
        var n = n
        var c = 0

        while (n != 0) {
            if (c == 3) {
                sb.append(".")
                c = 0
            }
            sb.append(n % 10)
            c++
            n /= 10
        }

        return sb.toString().reversed()
    }
}