package com.ypwang.easy

class Solution784 {
    fun helper(S: String): List<String> {
        if (S.length == 1) {
            if (S[0].isDigit()) {
                return listOf(S)
            } else {
                return listOf(S.lowercase(), S.uppercase())
            }
        }

        if (S[0].isDigit()) {
            return helper(S.takeLast(S.length-1)).map { "${S[0]}" + it }
        } else {
            val tmp = helper(S.takeLast(S.length-1)).map { S[0].lowercase() + it }.toMutableList()
            tmp.addAll(helper(S.takeLast(S.length-1)).map { S[0].uppercase() + it })
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