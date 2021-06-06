package com.ypwang.medium

class Solution1887 {
    fun reductionOperations(nums: IntArray): Int =
        nums.groupBy { it }
            .mapValues { it.value.size }
            .toList()
            .sortedByDescending { it.first }
            .fold(0 to 0) { (rst, cur), (_, c) ->
                rst + cur to cur + c
            }
            .first
}

fun main() {
    println(Solution1887().reductionOperations(intArrayOf(5,1,3)))
    println(Solution1887().reductionOperations(intArrayOf(1,1,1,1,1)))
    println(Solution1887().reductionOperations(intArrayOf(1,1,2,2,3)))
}