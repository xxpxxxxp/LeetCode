package com.ypwang.hard

class Solution420 {
    fun strongPasswordChecker(s: String): Int {
        var missing = 3
        if (s.any { it in 'a'..'z' }) missing--
        if (s.any { it in 'A'..'Z' }) missing--
        if (s.any { it.isDigit() }) missing--

        var change = 0
        var one = 0
        var two = 0
        var i = 0
        for (j in s.indices) {
            if (j == s.lastIndex || s[j+1] != s[i]) {
                val len = j - i + 1

                change += len / 3
                if (len >= 3) {
                    when (len % 3) {
                        0 -> one++
                        1 -> two++
                    }
                }

                i = j + 1
            }
        }

        return when {
            s.length < 6 -> maxOf(missing, 6 - s.length)
            s.length <= 20 -> maxOf(missing, change)
            else -> {
                val delete = s.length - 20
                change -= minOf(delete, one)
                change -= minOf(maxOf(delete - one, 0), two * 2) / 2
                change -= maxOf(delete - one - 2 * two, 0) / 3

                delete + maxOf(missing, change)
            }
        }
    }
}

fun main() {
    println(Solution420().strongPasswordChecker("1010101010aaaB10101010"))
    println(Solution420().strongPasswordChecker("ABABABABABABABABABAB1"))
    println(Solution420().strongPasswordChecker("aaa111"))
}