package com.ypwang.medium

class Solution2564 {
    fun substringXorQueries(s: String, queries: Array<IntArray>): Array<IntArray> {
        val map = mutableMapOf<Long, Pair<Int, Int>>()
        for ((i, c) in s.withIndex()) {
            if (c == '0') {
                if (0L !in map)
                    map[0L] = i to i
            } else {
                var n = 0L
                for (j in i..minOf(i+32, s.length-1)) {
                    n = (n shl 1) + (s[j] - '0')
                    if (n !in map)
                        map[n] = i to j
                }
            }
        }

        return queries.map { (a, b) -> a.toLong() xor b.toLong() }
            .map { map[it]?: (-1 to -1) }
            .map { (a, b) -> intArrayOf(a, b) }
            .toTypedArray()
    }
}

fun main() {
    println(Solution2564().substringXorQueries("101101", arrayOf(intArrayOf(0, 5))))
}