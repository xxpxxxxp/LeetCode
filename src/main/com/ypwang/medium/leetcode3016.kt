package com.ypwang.medium

class Solution3016 {
    fun minimumPushes(word: String): Int =
        word.groupBy { it }
            .map { it.value.size }
            .sortedDescending()
            .withIndex()
            .map { (i, v) -> (i+8) / 8 * v }
            .sum()!!
}

fun main() {
    println(Solution3016().minimumPushes("abcde"))
    println(Solution3016().minimumPushes("xyzxyzxyzxyz"))
    println(Solution3016().minimumPushes("aabbccddeeffgghhiiiiii"))
}
