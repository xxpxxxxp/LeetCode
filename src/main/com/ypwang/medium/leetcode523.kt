package com.ypwang.medium

class Solution523 {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        var sum = 0
        val cache = mutableMapOf(0 to -1)

        for ((i, n) in nums.withIndex()) {
            sum += n
            val mod = if (k == 0) sum else (sum % k).let { if (it < 0) it + k else it }
            if (mod in cache) {
                if (i - cache[mod]!! >= 2)
                    return true
            } else {
                cache[mod] = i
            }
        }

        return false
    }
}

fun main() {
    println(Solution523().checkSubarraySum(intArrayOf(5,0,0), 0))
}