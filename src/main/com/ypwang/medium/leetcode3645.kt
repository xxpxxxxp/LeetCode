package com.ypwang.medium

class Solution3645 {
    fun maxTotal(value: IntArray, limit: IntArray): Long =
        limit.zip(value)
            .groupBy { it.first }
            .flatMap { it.value.map { kv -> kv.second }.sortedDescending().take(it.key) }
            .fold(0L) { a, b -> a + b }
}
