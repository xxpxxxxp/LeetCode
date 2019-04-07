package com.ypwang.medium

class Solution390 {
    fun lastRemaining(n: Int): Int {
        return if (n == 1) 1 else (n shr 1) - lastRemaining(n shr 1) + 1 shl 1
    }
}

fun main() {
    println(Solution390().lastRemaining(9))
}