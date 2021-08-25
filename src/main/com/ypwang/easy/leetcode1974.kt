package com.ypwang.easy

class Solution1974 {
    fun minTimeToType(word: String): Int =
        word.fold('a' to 0) { (pre, sum), cur ->
            val dis = (cur - pre + 26) % 26
            cur to sum + minOf(dis, 26-dis)
        }.second + word.length
}

fun main() {
    println(Solution1974().minTimeToType("abc"))
    println(Solution1974().minTimeToType("bza"))
    println(Solution1974().minTimeToType("zjpc"))
}