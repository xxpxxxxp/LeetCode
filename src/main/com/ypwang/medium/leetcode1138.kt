package com.ypwang.medium

import java.lang.StringBuilder

class Solution1138 {
    fun alphabetBoardPath(target: String): String {
        val map = mutableMapOf<Char, Pair<Int, Int>>()

        for (i in 0 until 26) {
            map['a' + i] = i / 5 to i % 5
        }

        val sb = StringBuilder()
        var cur = 'a'
        for (c in target) {
            val cp = map[cur]!!
            val tr = map[c]!!
            val x = tr.first - cp.first
            val y = tr.second - cp.second

            if (y < 0) sb.append((0 until -y).map { 'L' }.joinToString(""))
            if (x < 0) sb.append((0 until -x).map { 'U' }.joinToString(""))
            if (y > 0) sb.append((0 until y).map { 'R' }.joinToString(""))
            if (x > 0) sb.append((0 until x).map { 'D' }.joinToString(""))

            sb.append('!')
            cur = c
        }

        return sb.toString()
    }
}

fun main() {
    println(Solution1138().alphabetBoardPath("leet"))
}