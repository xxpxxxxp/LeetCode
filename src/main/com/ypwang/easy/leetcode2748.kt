package com.ypwang.easy

class Solution2748 {
    fun gcd(a: Int, b: Int): Int {
        return if (a == 0) b else gcd(b % a, a)
    }

    fun countBeautifulPairs(nums: IntArray): Int {
        var rst = 0
        for ((i, n) in nums.withIndex()) {
            val f = n.toString().first() - '0'
            for (j in i+1 until nums.size) {
                val l = nums[j].toString().last() - '0'
                if (gcd(f, l) == 1)
                    rst++
            }
        }

        return rst
    }
}