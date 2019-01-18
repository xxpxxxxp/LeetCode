package com.ypwang.medium

class Solution740 {
    fun deleteAndEarn(nums: IntArray): Int {
        val m = nums.groupBy { it }.mapValues { it.value.sum() }.toMutableMap()

        fun findMax(map: Map<Int, Int>, start: Int): Int {
            var index = start
            var dp = Pair(0, map[index]!!)     // no contain, contain

            while ((index + 1) in map) {
                index += 1
                dp = Pair(Math.max(dp.first, dp.second), dp.first + map[index]!!)
            }

            return Math.max(dp.first, dp.second)
        }

        var sum = 0
        while (m.isNotEmpty()) {
            val start = m.keys.min()!!
            var p = start

            val group = mutableMapOf(Pair(p, m[p]!!))
            m.remove(p)
            while ((p + 1) in m) {
                p += 1
                group[p] = m[p]!!
                m.remove(p)
            }

            sum += findMax(group, start)
        }

        return sum
    }
}

fun main(args: Array<String>) {
    val t = intArrayOf(10,8,4,2,1,3,4,8,2,9,10,4,8,5,9,1,5,1,6,8,1,1,6,7,8,9,1,7,6,8,4,5,4,1,5,9,8,6,10,6,4,3,8,4,10,8,8,10,6,4,4,4,9,6,9,10,7,1,5,3,4,4,8,1,1,2,1,4,1,1,4,9,4,7,1,5,1,10,3,5,10,3,10,2,1,10,4,1,1,4,1,2,10,9,7,10,1,2,7,5)
    println(Solution740().deleteAndEarn(t))
}