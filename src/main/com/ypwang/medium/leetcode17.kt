package com.ypwang.medium

class Solution17 {
    private val m = mapOf(
            '2' to "abc",
            '3' to "def",
            '4' to "ghi",
            '5' to "jkl",
            '6' to "mno",
            '7' to "pqrs",
            '8' to "tuv",
            '9' to "wxyz"
    )

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) {
            return listOf()
        }

        val count = digits.map { m.getValue(it).length }.reduce { acc, i -> acc * i }

        val rst = Array(count){ "" }

        for (i in 0 until rst.size) {
            var index = i
            val sb = StringBuilder()

            for (d in digits) {
                val s = m.getValue(d)
                sb.append(s[index % s.length])
                index /= s.length
            }

            rst[i] = sb.toString()
        }

        return rst.toList()
    }
}

fun main(args: Array<String>) {
    println(Solution17().letterCombinations("23"))
}