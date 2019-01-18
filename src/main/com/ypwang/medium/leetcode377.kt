package com.ypwang.medium

class Solution377 {
    fun combinationSum4(nums: IntArray, target: Int): Int {
        val cache = mutableMapOf<Int, Int>()

        fun counting(now: Int): Int {
            if (now in cache)
                return cache[now]!!

            if (now == 0)
                return 1

            if (now <= 0)
                return 0

            cache[now] = nums.filter { now >= it }.sumBy { counting(now - it) }
            return cache[now]!!
        }

        counting(target)
        return cache[target]!!
    }
}

fun main(args: Array<String>) {
    println(Solution377().combinationSum4(intArrayOf(3, 33, 333), 10000))
}