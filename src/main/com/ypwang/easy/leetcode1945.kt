package com.ypwang.easy

class Solution1945 {
    fun getLucky(s: String, k: Int): Int {
        var c = s.flatMap { (it - 'a' + 1).toString().toList() }
        for (i in 0 until k)
            c = c.fold(0) { sum, a -> sum + (a - '0') }.toString().toList()

        return c.joinToString("").toInt()
    }
}