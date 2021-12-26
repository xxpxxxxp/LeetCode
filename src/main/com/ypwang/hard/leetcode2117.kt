package com.ypwang.hard

class Solution2117 {
    fun abbreviateProduct(left: Int, right: Int): String {
        var pref = 1.0
        var suf = 1L
        var c = 0

        for (i in left..right) {
            pref *= i
            while (pref >= 1000000)
                pref /= 10

            suf *= i
            while (suf % 10 == 0L) {
                suf /= 10
                c++
            }

            suf %= 1000000000000L
        }

        val s = suf.toString()
        return (if (s.length <= 10) s else pref.toInt().toString().take(5) + "..." + s.substring(s.length - 5)) + "e" + c.toString()
    }
}

fun main() {
    println(Solution2117().abbreviateProduct(999998, 1000000))
}