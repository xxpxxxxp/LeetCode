package com.ypwang.hard

class Solution3267 {
    fun countPairs(nums: IntArray): Int {
        val frequences = mutableMapOf<Int, Int>()
        var result = 0
        for (value in nums) {
            result += frequences.getOrDefault(value, 0)
            val twoSwapVariations =
                allOneSwapVariations(value)
                    .flatMap { allOneSwapVariations(it) }
                    .toSet()

            for (twoSwapVariation in twoSwapVariations)
                frequences.compute(twoSwapVariation) { _, v -> 1 + (v ?: 0) }
        }

        return result
    }

    private fun allOneSwapVariations(number: Int): Set<Int> {
        val variations = mutableSetOf(number)

        // try swaping any pair of digits
        for (i in 0 until maxDigits) {
            for (j in i + 1 until maxDigits) {
                val di = (number / pow10[i]) % 10
                val dj = (number / pow10[j]) % 10
                if (di == dj)
                    continue

                // swapping digits i and j
                val diff1variation = (number
                        - di * pow10[i] + di * pow10[j]
                        - dj * pow10[j] + dj * pow10[i])
                variations.add(diff1variation)
            }
        }
        return variations
    }

    companion object {
        val maxDigits = 7
        val pow10 = intArrayOf(1, 10, 100, 1000, 10000, 100000, 1000000)
    }
}
