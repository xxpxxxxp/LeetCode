package com.ypwang.medium

class Solution3867 {
    fun gcd(a: Int, b: Int): Int = if (a == 0) b else gcd(b % a, a)

    fun gcdSum(nums: IntArray): Long {
        val prefixGcd = IntArray(nums.size)

        var max = Int.MIN_VALUE
        for ((i, v) in nums.withIndex()) {
            max = maxOf(max, v)
            prefixGcd[i] = gcd(v, max)
        }

        prefixGcd.sort()
        var rst = 0L
        for (i in 0 until prefixGcd.size / 2)
            rst += gcd(prefixGcd[i], prefixGcd[prefixGcd.size-1-i])

        return rst
    }
}

fun main() {
    println(Solution3867().gcdSum(intArrayOf(2,6,4)))
}