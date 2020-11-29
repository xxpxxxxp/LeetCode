package com.ypwang.easy

import java.lang.StringBuilder

class Solution686 {
    fun repeatedStringMatch(A: String, B: String): Int {
        val c = B.length / A.length + if (B.length % A.length == 0) 0 else 1
        var t = StringBuilder().apply {
            for (i in 0 until c) {
                append(A)
            }
        }.toString()
        if (t.indexOf(B) >= 0) {
            return c
        }
        t += A
        if (t.indexOf(B) >= 0) {
            return c+1
        }
        return -1
    }
}

fun main() {
    println(Solution686().repeatedStringMatch("a", "aa"))
}