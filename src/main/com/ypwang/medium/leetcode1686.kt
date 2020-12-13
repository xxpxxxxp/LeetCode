package com.ypwang.medium

class Solution1686 {
    fun stoneGameVI(aliceValues: IntArray, bobValues: IntArray): Int {
        val t = aliceValues.zip(bobValues).map { Triple(it.first, it.second, it.first + it.second) }.sortedByDescending { it.third }

        var a = 0
        var b = 0

        for ((i, v) in t.withIndex()) {
            if (i % 2 == 0)
                a += v.first
            else
                b += v.second
        }

        return a.compareTo(b)
    }
}

fun main() {
    println(Solution1686().stoneGameVI(intArrayOf(1,3), intArrayOf(2,1)))
    println(Solution1686().stoneGameVI(intArrayOf(1,2), intArrayOf(3,1)))
    println(Solution1686().stoneGameVI(intArrayOf(2,4,3), intArrayOf(2,6,7)))
}