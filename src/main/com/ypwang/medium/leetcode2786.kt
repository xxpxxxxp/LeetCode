package com.ypwang.medium

class Solution2786 {
    fun maxScore(nums: IntArray, x: Int): Long {
        var odd = nums.first().toLong()
        var even = nums.first().toLong()
        if (nums.first() % 2 == 0)
            odd -= x
        else
            even -= x

        for (i in 1 until nums.size) {
            val v = nums[i]
            if (v % 2 == 0)
                even = v + maxOf(even, odd - x)
            else
                odd = v + maxOf(odd, even - x)
        }

        return maxOf(odd, even)
    }
}

fun main() {
    println(Solution2786().maxScore(intArrayOf(2,3,6,1,9,2), 5))
}