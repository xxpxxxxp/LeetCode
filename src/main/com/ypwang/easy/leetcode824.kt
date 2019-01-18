package com.ypwang.easy

class Solution824 {
    fun toGoatLatin(S: String) = S.split(' ').mapIndexed { index, str ->
            when (str[0]) {
                in "aeiouAEIOU" ->str + "ma" + "a".repeat(index+1)
                else -> str.takeLast(str.lastIndex) + str[0] + "ma" + "a".repeat(index+1)
            }
        }.joinToString(" ")
}