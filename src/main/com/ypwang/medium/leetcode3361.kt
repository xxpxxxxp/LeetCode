package com.ypwang.medium

class Solution3361 {
    fun shiftDistance(s: String, t: String, nextCost: IntArray, previousCost: IntArray): Long {
        val n = s.length
        val next = LongArray(26) { nextCost[it].toLong() }
        val prev = LongArray(26) { previousCost[it].toLong() }

        // Calculate cumulative costs for next and previous
        for (i in 1 until 26)
            next[i] += next[i - 1]

        for (i in 24 downTo 0)
            prev[i] += prev[i + 1]

        var cost = 0L
        for (i in 0 until n) {
            if (s[i] != t[i]) {
                val start = s[i] - 'a'
                val end = t[i] - 'a'

                if (start < end) {
                    val forwardCost = next[end - 1] - (if (start > 0) next[start - 1] else 0)
                    val backwardCost = prev[0] - (if (start + 1 < 26) prev[start + 1] else 0) + (if (end == 25) 0 else prev[end + 1])
                    cost += minOf(forwardCost, backwardCost)
                } else {
                    val backwardCost = prev[end + 1] - (if (start >= 25) 0 else prev[start + 1])
                    val forwardCost = next[25] - next[start - 1] + (if (end != 0) next[end - 1] else 0)
                    cost += minOf(forwardCost, backwardCost)
                }
            }
        }

        return cost
    }
}

fun main() {
    println(Solution3361().shiftDistance(
        "abab",
        "baba",
        intArrayOf(100,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
        intArrayOf(1,100,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
    ))
}