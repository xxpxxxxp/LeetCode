package com.ypwang.medium

class Solution40 {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val i = mutableSetOf<Pair<Int, List<Int>>>(0 to listOf())

        for (c in candidates.sorted()) {
            val t = mutableListOf<Pair<Int, List<Int>>>()
            for (item in i) {
                if (item.first + c <= target) {
                    t.add((item.first + c) to (item.second + c))
                }
            }
            i.addAll(t)
        }

        return i.filter { it.first == target }.map { it.second }
    }
}

fun main(args: Array<String>) {
    println(Solution40().combinationSum2(intArrayOf(2,5,2,1,2), 5))
}