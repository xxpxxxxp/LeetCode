package com.ypwang.easy

class Solution784 {
    fun helper(S: String): List<String> {
        if (S.length == 1) {
            if (S[0].isDigit()) {
                return listOf(S)
            } else {
                return listOf(S.toLowerCase(), S.toUpperCase())
            }
        }

        if (S[0].isDigit()) {
            return helper(S.takeLast(S.length-1)).map { "${S[0]}" + it }
        } else {
            val tmp = helper(S.takeLast(S.length-1)).map { "${S[0].toLowerCase()}" + it }.toMutableList()
            tmp.addAll(helper(S.takeLast(S.length-1)).map { "${S[0].toUpperCase()}" + it })
            return tmp
        }
    }

    fun letterCasePermutation(S: String): List<String> {
        if (S.isEmpty()) {
            return listOf()
        }
        return helper(S)
    }
}

fun main() {
    println(Solution784().letterCasePermutation("a1b1"))
}