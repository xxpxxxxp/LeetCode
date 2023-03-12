package com.ypwang.medium

class Solution2588 {
    fun beautifulSubarrays(nums: IntArray): Long =
        nums.fold(Triple(0, 0L, mutableMapOf<Int, Int>(0 to 1))) { (cur, rst, map), v ->
            val next = cur xor v
            val pre = map.getOrDefault(next, 0)
            map[next] = pre+1
            Triple(next, rst + pre, map)
        }.second
}

fun main() {
    println(Solution2588().beautifulSubarrays(intArrayOf(4,3,1,2,4)))
}