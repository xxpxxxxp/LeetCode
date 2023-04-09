package com.ypwang.medium

class Solution2615 {
    fun distance(nums: IntArray): LongArray {
        val rst = LongArray(nums.size)

        nums.withIndex()
            .groupBy { it.value }
            .forEach {
                val idx = it.value.map { kv -> kv.index }.sorted()
                var preSum = 0L
                var postSum = idx.fold(0L) { a, b -> a + b }

                for ((j, i) in idx.withIndex()) {
                    preSum += i
                    rst[i] = postSum - (idx.size - 1 - j.toLong()) * i + j.toLong() * i - preSum
                    postSum -= i
                }
            }

        return rst
    }
}

fun main() {
    println(Solution2615().distance(intArrayOf(1,3,1,1,2)).toList())
}