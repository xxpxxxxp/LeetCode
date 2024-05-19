package com.ypwang.medium

class Solution3153 {
    fun sumDigitDifferences(nums: IntArray): Long {
        val len = nums[0].toString().length
        var x = 1
        var rst = 0L
        for (i in 0 until len) {
            val l = mutableListOf<Int>()
            for (n in nums)
                l.add(n % (x * 10) / x)

            val g = l.groupBy { it }.map { it.value.size }
            var c = nums.size
            for (v in g) {
                c -= v
                rst += v * c
            }

            x *= 10
        }

        return rst
    }
}

fun main() {
    println(Solution3153().sumDigitDifferences(intArrayOf(13,23,12)))
}
