package com.ypwang.medium

class Solution2501 {
    fun longestSquareStreak(nums: IntArray): Int {
        nums.sort()
        val mp = mutableMapOf<Int, Int>()
        var max = 1
        for (v in nums) {
            val s = Math.sqrt(v.toDouble()).toInt()
            if (s * s == v && s in mp) {
                val l = mp[s]!! + 1
                mp[v] = l
                max = maxOf(max, l)
            } else{
                mp[v] = 1
            }
        }

        return if (max >= 2) max else -1
    }
}

fun main() {
    println(Solution2501().longestSquareStreak(intArrayOf(4,3,6,16,8,2)))
}