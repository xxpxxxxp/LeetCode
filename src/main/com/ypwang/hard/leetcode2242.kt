package com.ypwang.hard

class Solution2242 {
    fun maximumScore(scores: IntArray, edges: Array<IntArray>): Int {
        val conns = edges.flatMap { (a, b) -> listOf(Triple(a, b, scores[a] + scores[b]), Triple(b, a, scores[a] + scores[b])) }
            .groupBy { it.first }
            .map { it.key to it.value.sortedByDescending { t -> t.third }.take(3) }
            .toMap()

        var max = -1
        for ((a, b) in edges) {
            for ((_, i, s1) in conns.getOrDefault(a, listOf())) {
                for ((_, j, s2) in conns.getOrDefault(b, listOf())) {
                    if (i != b && j != a && i != j)
                        max = maxOf(max, s1 + s2)
                }
            }
        }

        return max
    }
}

fun main() {
    println(Solution2242().maximumScore(
        intArrayOf(5,2,9,8,4), arrayOf(
            intArrayOf(0,1),intArrayOf(1,2),intArrayOf(2,3),intArrayOf(0,2),intArrayOf(1,3),intArrayOf(2,4)
        )
    ))
}