package com.ypwang.medium

class Solution659 {
    fun isPossible(nums: IntArray): Boolean {
        val count = nums.groupBy { it }.mapValues { it.value.size }.toMutableMap()
        val tail = mutableMapOf<Int, Int>()

        val start = count.minByOrNull { it.key }!!.key
        val end = count.maxByOrNull { it.key }!!.key

        for (i in start..end) {
            if (count.getOrDefault(i, 0) == 0) continue

            var cur = count[i]!!
            if (tail.getOrDefault(i, 0) > 0) {
                val m = minOf(cur, tail[i]!!)
                tail[i] = tail[i]!! - m
                tail[i+1] = tail.getOrDefault(i+1, 0) + m
                cur -= m
            }

            if (cur > 0) {
                if (count.getOrDefault(i+1, 0) >= cur && count.getOrDefault(i+2, 0) >= cur) {
                    count[i+1] = count[i+1]!! - cur
                    count[i+2] = count[i+2]!! - cur
                    tail[i+3] = tail.getOrDefault(i+3, 0) + cur
                } else {
                    return false
                }
            }

            count[i] = 0
        }

        return true
    }
}

fun main() {
    println(Solution659().isPossible(intArrayOf(1,2,3,3,4,5)))
    println(Solution659().isPossible(intArrayOf(1,2,3,3,4,4,5,5)))
    println(Solution659().isPossible(intArrayOf(1,2,3,4,4,5)))
}