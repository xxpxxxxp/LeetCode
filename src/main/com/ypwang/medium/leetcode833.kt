package com.ypwang.medium

import java.lang.StringBuilder

class Solution833 {
    fun findReplaceString(S: String, indexes: IntArray, sources: Array<String>, targets: Array<String>): String {
        var start = 0
        val sb = StringBuilder()

        val r = indexes.zip(sources).zip(targets).map { Triple(it.first.first, it.first.second, it.second) }.sortedBy { it.first }

        for (rp in r) {
            if (start < rp.first) {
                sb.append(S.substring(start, rp.first))
                start = rp.first
            }

            val sub = S.substring(start, start + rp.second.length)
            if (sub == rp.second) {
                sb.append(rp.third)
            } else {
                sb.append(sub)
            }

            start += rp.second.length
        }

        if (start < S.length) {
            sb.append(S.substring(start, S.length))
        }

        return sb.toString()
    }
}

fun main(args: Array<String>) {
    println(Solution833().findReplaceString("abcd", intArrayOf(0, 2), arrayOf("ab", "ec"), arrayOf("eee", "fff")))
}