package com.ypwang.medium

class Solution39 {
    fun combinationSum(candidates: List<Int>, target: Int): List<List<Int>> {
        println(candidates)
        println(target)
        println("")
        if (target == 0) return listOf(listOf())
        if (candidates.isEmpty()) return listOf()

        val first = candidates.first()
        val left = candidates.drop(1)
        return (0..(target / candidates.first())).flatMap {
            val rst = combinationSum(left, target - first * it)
            if (rst.isEmpty()) rst
            else {
                rst.map { l -> List(it){ first } + l }
            }
        }
    }

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> = combinationSum(candidates.toList(), target)
}

fun main() {
    println(Solution39().combinationSum(intArrayOf(1), 2))
}