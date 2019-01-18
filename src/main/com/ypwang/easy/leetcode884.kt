package com.ypwang.easy

class Solution884 {
    fun uncommonFromSentences(A: String, B: String): Array<String> {
        return ("$A $B").split(' ').groupBy { it }.filter { it.value.size == 1 }.map{ it.key }.toTypedArray()
    }
}

fun main(args: Array<String>) {
    println(Solution884().uncommonFromSentences("s z z z s", "s z ejt"))
}