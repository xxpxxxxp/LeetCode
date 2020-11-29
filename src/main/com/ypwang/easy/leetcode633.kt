package com.ypwang.easy

class Solution633 {
    fun judgeSquareSum(c: Int): Boolean {
        val t = mutableSetOf<Int>()
        var i = 0
        while (true) {
            val s = i * i
            if (s > c || i > 46340) {
                return false
            }
            t.add(s)
            if (c - s in t) {
                return true
            }
            i++
        }
    }
}

fun main() {
    println(Solution633().judgeSquareSum(2147482647))
}