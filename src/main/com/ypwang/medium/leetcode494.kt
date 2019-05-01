package com.ypwang.medium

class Solution494 {
    fun findTargetSumWays(nums: IntArray, S: Int): Int =
        nums.fold(mapOf(0 to 1)) { cur, num ->
            cur.flatMap { listOf(it.key + num to it.value, it.key - num to it.value) }
                    .groupBy { it.first }
                    .mapValues { it.value.sumBy { v -> v.second } }
        }.getOrDefault(S, 0)
}

fun main() {
    println(Solution494().findTargetSumWays(intArrayOf(1, 1, 1, 1, 1), 3))
}