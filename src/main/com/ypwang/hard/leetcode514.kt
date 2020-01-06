package com.ypwang.hard

class Solution514 {
    fun findRotateSteps(ring: String, key: String): Int {
        var dp = mapOf(0 to 0)
        val pos = ring.withIndex().groupBy { it.value }.mapValues { it.value.map { kv -> kv.index } }

        for (c in key) {
            val next = pos[c]!!.map { it to Int.MAX_VALUE }.toMap().toMutableMap()
            for ((p, step) in dp) {
                for ((q, cur) in next) {
                    val t = minOf((p - q + ring.length) % ring.length, (q - p + ring.length) % ring.length)
                    if (cur > step + t) next[q] = step + t
                }
            }
            dp = next
        }

        return dp.values.min()!! + key.length
    }
}

fun main() {
    println(Solution514().findRotateSteps("godding", "godding"))
}