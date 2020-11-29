package com.ypwang.medium

class Solution712 {
    fun minimumDeleteSum(s1: String, s2: String): Int {
        val cache = Array(s1.length + 1) { Array(s2.length + 1){0} }

        for (i in s1.lastIndex downTo 0) {
            cache[i][s2.lastIndex+1] = cache[i+1][s2.lastIndex+1] + s1[i].toInt()
        }
        for (i in s2.lastIndex downTo 0) {
            cache[s1.lastIndex+1][i] = cache[s1.lastIndex+1][i+1] + s2[i].toInt()
        }

        for (i in s1.lastIndex downTo 0) {
            for (j in s2.lastIndex downTo 0) {
                cache[i][j] =
                        if (s1[i] == s2[j]) cache[i+1][j+1] else Math.min(cache[i+1][j] + s1[i].toInt(), cache[i][j+1] + s2[j].toInt())
            }
        }
        return cache[0][0]
    }
}

fun main() {
    println(Solution712().minimumDeleteSum("sea","eat"))
}