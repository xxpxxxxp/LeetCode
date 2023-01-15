package com.ypwang.medium

class Solution2537 {
    fun countGood(nums: IntArray, k: Int): Long {
        val counter = mutableMapOf<Int, Int>()
        var j = 0
        var goods = 0L
        var c = 0L

        for ((i, v) in nums.withIndex()) {
            while (j < nums.size && goods < k) {
                val v1 = nums[j++]
                var c1 = 0
                if (v1 in counter) {
                    c1 = counter[v1]!!
                    goods -= (c1 - 1) * c1 / 2
                }
                counter[v1] = ++c1
                goods += (c1 - 1) * c1 / 2
            }

            if (goods < k)
                break

            c += nums.size + 1 - j
            val c2 = counter[v]!!
            goods -= (c2 - 1) * c2 / 2
            counter[v] = c2 - 1
            goods += (c2 - 2) * (c2 - 1) / 2
        }

        return c
    }
}

fun main() {
    println(Solution2537().countGood(intArrayOf(1, 1, 1, 1, 1), 10))
    println(Solution2537().countGood(intArrayOf(3, 1, 4, 3, 2, 2, 4), 2))
}