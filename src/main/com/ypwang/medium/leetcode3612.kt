package com.ypwang.medium

class Solution3612 {
    fun processStr(s: String): String {
        val sb = StringBuilder()

        for (c in s) {
            when (c) {
                '*' ->
                    if (sb.isNotEmpty())
                        sb.setLength(sb.lastIndex)
                '#' ->
                    sb.append(sb.toString())
                '%' ->
                    sb.reverse()
                else ->
                    sb.append(c)
            }
        }

        return sb.toString()
    }
}

fun main() {
    println(Solution3612().processStr("a#b%*"))
}