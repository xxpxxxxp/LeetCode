package com.ypwang.hard

class Solution828 {
    val mod = 1000000007
    fun uniqueLetterString(S: String): Int =
        S.withIndex().groupBy { it.value }.map { it.value.map { i -> i.index } }
            .fold(0) { cur, it ->
                val array = it.toTypedArray()
                (cur + (0 until array.size).sumBy {
                    i -> (array[i] - (if (i == 0) -1 else array[i-1])) * ((if (i == array.lastIndex) S.length else array[i+1]) - array[i])
                }) % mod
            }
}

fun main() {
    println(Solution828().uniqueLetterString("A"))
}