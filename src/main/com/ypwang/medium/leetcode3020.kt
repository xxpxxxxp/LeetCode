package com.ypwang.medium

class Solution3020 {
    fun maximumLength(nums: IntArray): Int {
        val counts = nums.groupBy { it }.mapValues { it.value.size }

        var rst = 0
        for ((k, c) in counts.toList().sortedBy { it.first }) {
            if (k == 1) {
                rst = (c - 1) / 2 * 2 + 1
                continue
            }
            var k = k
            var c = c
            var cur = 1
            while (c > 1 && k * k in counts) {
                k = k * k
                c = counts[k]!!
                cur += 2
            }

            rst = maxOf(rst, cur)
        }

        return rst
    }
}

fun main() {
    println(Solution3020().maximumLength(intArrayOf(5,4,1,2,2)))
    println(Solution3020().maximumLength(intArrayOf(1,3,2,4)))
    println(Solution3020().maximumLength(intArrayOf(2, 4, 16, 4, 2)))
    println(Solution3020().maximumLength(intArrayOf(3, 9, 3)))
}
