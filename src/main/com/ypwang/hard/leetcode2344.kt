package com.ypwang.hard

class Solution2344 {
    private fun gcd(a: Int, b: Int): Int =
        if (a == 0) b else gcd(b % a, a)

    fun minOperations(nums: IntArray, numsDivide: IntArray): Int {
        nums.sort()
        val div = numsDivide.reduce { a, b -> gcd(a, b) }
        for ((i, v) in nums.withIndex())
            if (div % v == 0)
                return i

        return -1
    }
}