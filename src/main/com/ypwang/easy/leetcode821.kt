package com.ypwang.easy
import kotlin.math.*

class Solution821 {
    fun shortestToChar(S: String, C: Char): IntArray {
        val asc = MutableList(S.length) { 0 }
        val desc = MutableList(S.length) { 0 }
        var foot = 10000
        for (i in 0 until S.length) {
            foot++
            if (S[i] == C) {
                foot = 0
            }
            asc[i] = foot
        }

        foot = 10000
        for (i in (0 until S.length).reversed()) {
            foot++
            if (S[i] == C) {
                foot = 0
            }
            desc[i] = foot
        }

        return asc.zip(desc).map { min(it.first, it.second) }.toIntArray()
    }
}

fun main() {
    println(Solution821().shortestToChar("loveleetcode", 'e'))
}