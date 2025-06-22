package com.ypwang.easy

class Solution3591 {
    fun checkPrimeFrequency(nums: IntArray): Boolean {
        val primes = setOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97)
        return nums.groupBy { it }.map { it.value.size }.any { it in primes }
    }
}
