package com.ypwang.easy

import java.lang.StringBuilder

class Solution929 {
    fun numUniqueEmails(emails: Array<String>): Int {
        return emails.map {
            val parts = it.split('@')
            StringBuilder().apply {
                val i = parts[0].indexOfFirst { c -> c == '+' }
                (if (i > 0) parts[0].substring(0, i) else parts[0]).split('.').forEach {
                    s -> append(s)
                }
                append('@')
                append(parts[1])
            }.toString()
        }.toSet().size
    }
}

fun main(args: Array<String>) {
    println(Solution929().numUniqueEmails(arrayOf("test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com")))
}