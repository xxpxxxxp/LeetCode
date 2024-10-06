package com.ypwang.hard

class Solution3312 {
    fun gcdValues(nums: IntArray, queries: LongArray): IntArray {
        val n = nums.size
        val maxValue = nums.maxOrNull() ?: 0
        val divisorCount = IntArray(maxValue + 1)

        for (number in nums) {
            for (i in 1..Math.sqrt(number.toDouble()).toInt()) {
                if (number % i == 0) {
                    divisorCount[i]++
                    if (i != number / i)
                        divisorCount[number / i]++
                }
            }
        }

        val gcdPairCount = LongArray(maxValue + 1)

        for (gcd in maxValue downTo 1) {
            val count = divisorCount[gcd]
            gcdPairCount[gcd] = count.toLong() * (count - 1) / 2
            for (multiple in 2 * gcd..maxValue step gcd) {
                gcdPairCount[gcd] -= gcdPairCount[multiple]
            }
        }

        val prefixSum = LongArray(maxValue + 1)
        for (gcd in 1..maxValue)
            prefixSum[gcd] = prefixSum[gcd - 1] + gcdPairCount[gcd]

        val result = IntArray(queries.size)
        for (i in queries.indices) {
            val query = queries[i]
            var left = 1L
            var right = maxValue.toLong()
            var answer = -1L
            while (left <= right) {
                val mid = (left + right) / 2
                if (prefixSum[mid.toInt()] > query) {
                    answer = mid
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
            result[i] = answer.toInt()
        }

        return result
    }
}
