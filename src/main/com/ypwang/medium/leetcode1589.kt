package com.ypwang.medium

class Solution1589 {
    fun maxSumRangeQuery(nums: IntArray, requests: Array<IntArray>): Int {
        val counts = IntArray(nums.size)

        for ((i, j) in requests) {
            counts[i]++
            if (j < counts.lastIndex)
                counts[j+1]--
        }

        var c = 0
        for (i in counts.indices) {
            c += counts[i]
            counts[i] = c
        }

        return counts.sorted().zip(nums.sorted()).fold(0) { acc, (i, j) ->
            (acc + i * j) % 1000000007
        }
    }
}

fun main() {
    println(Solution1589().maxSumRangeQuery(intArrayOf(1,2,3,4,5), arrayOf(
            intArrayOf(1,3), intArrayOf(0,1)
    )))
}