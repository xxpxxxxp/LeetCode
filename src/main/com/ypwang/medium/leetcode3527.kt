package com.ypwang.medium

class Solution3527 {
    fun findCommonResponse(responses: List<List<String>>): String {
        val r = responses.flatMap { it.toSet() }.groupBy { it }.mapValues { it.value.size }
        val min = r.values.max()
        return r.filter { it.value == min }.map { it.key }.min()
    }
}
