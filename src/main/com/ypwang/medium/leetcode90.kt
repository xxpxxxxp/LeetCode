package com.ypwang.medium

class Solution90 {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val set = nums.groupBy { it }.mapValues { it.value.size }.toList()
        val num = set.map { it.second + 1 }.reduce { acc, i -> acc * i }

        val rst = mutableListOf<List<Int>>()
        for (i in 0 until num) {
            val round = mutableListOf<Int>()
            var index = i
            for (pair in set) {
                round.addAll((0 until index % (pair.second + 1)).map { pair.first })
                index /= (pair.second + 1)
            }
            rst.add(round)
        }
        return rst
    }
}

fun main() {
    println(Solution90().subsetsWithDup(intArrayOf(1,2,2)))
}