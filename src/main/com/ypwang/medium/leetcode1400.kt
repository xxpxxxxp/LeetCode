package com.ypwang.medium

class Solution1400 {
    fun canConstruct(s: String, k: Int): Boolean {
        val exist = BooleanArray(26)
        for (c in s) {
            val i = c - 'a'
            exist[i] = !exist[i]
        }

        return k in exist.count { it }..s.length
    }
}

fun main() {
    println(Solution1400().canConstruct("ibzkwaxxaggkiwjbeysz",15))
    println(Solution1400().canConstruct("qlkzenwmmnpkopu",15))
    println(Solution1400().canConstruct("annabelle", 2))
    println(Solution1400().canConstruct("leetcode", 3))
    println(Solution1400().canConstruct("true", 4))
    println(Solution1400().canConstruct("yzyzyzyzyzyzyzy", 2))
    println(Solution1400().canConstruct("cr", 7))
}