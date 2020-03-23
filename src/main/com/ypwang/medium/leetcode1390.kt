package com.ypwang.medium

class Solution1390 {
    fun sumFourDivisors(nums: IntArray): Int {
        var rst = 0
        val divisor = IntArray(2)

        outer@ for (num in nums) {
            var idx = 0
            for (i in 1..Math.sqrt(num.toDouble()).toInt()) {
                if (num % i == 0) {
                    if (num / i == i || idx > 1) continue@outer
                    divisor[idx++] = i
                }
            }

            if (idx == 2)
                rst += divisor[0] + divisor[1] + num / divisor[0] + num / divisor[1]
        }

        return rst
    }
}

fun main() {
    println(Solution1390().sumFourDivisors(intArrayOf(21, 4, 7)))
}