package com.ypwang.easy

class Solution788 {
    fun rotatedDigits(N: Int): Int {
        val s = setOf('0', '1', '8', '2', '5', '6', '9')
        return (0..N).filter(fun(i): Boolean {
            val si = i.toString()
            if (!si.all { c -> c in s }) {
                return false
            }

            return si.map {
                when (it) {
                    '2' -> '5'
                    '5' -> '2'
                    '6' -> '9'
                    '9' -> '6'
                    else -> it
                }
            }.joinToString("") != si
        }).count()
    }
}

fun main() {
    println(Solution788().rotatedDigits(10))
}