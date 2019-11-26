package com.ypwang.medium

import java.lang.StringBuilder

class Solution1249 {
    fun minRemoveToMakeValid(s: String): String {
        var cnt = 0
        val sb = StringBuilder()
        for (c in s) {
            when (c) {
                '(' -> {
                    cnt++
                    sb.append('(')
                }
                ')' -> {
                    if (cnt > 0) {
                        sb.append(')')
                        cnt--
                    }
                }
                else -> sb.append(c)
            }
        }

        if (cnt > 0) {
            val nsb = StringBuilder()
            for (c in sb.reverse()) {
                if (c == '(' && cnt > 0) cnt--
                else nsb.append(c)
            }

            return nsb.reverse().toString()
        }

        return sb.toString()
    }
}

fun main() {
    println(Solution1249().minRemoveToMakeValid("lee(t(c)o)de)"))
    println(Solution1249().minRemoveToMakeValid("a)b(c)d"))
    println(Solution1249().minRemoveToMakeValid("))(("))
    println(Solution1249().minRemoveToMakeValid("(a(b(c)d)"))
}