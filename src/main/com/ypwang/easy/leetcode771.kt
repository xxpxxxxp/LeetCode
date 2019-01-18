package com.ypwang.easy

private class Solution771 {
    fun numJewelsInStones(J: String, S: String): Int {

        val c = S.groupBy { it }.mapValues { it.value.count() }
        var total = 0
        for (j in J) {
            total += c[j] ?: 0
        }
        return total
    }
}

fun main(args: Array<String>) {
    println(Solution771().numJewelsInStones("aA", "aAAAbbBB"))
}