package com.ypwang.medium

class Solution3741 {
    fun minimumDistance(nums: IntArray): Int =
        nums.withIndex()
            .groupBy { it.value }
            .map { it.value.map { kv -> kv.index } }
            .minOf {
                if (it.size < 3)
                    Int.MAX_VALUE
                else {
                    val arr = it.toTypedArray()
                    (2 until arr.size).minOf { i -> 2 * (arr[i] - arr[i-2]) }
                }
            }.let {
                if (it == Int.MAX_VALUE)
                    -1
                else
                    it
            }
}
