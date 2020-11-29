package com.ypwang.medium

class Solution739 {
    fun dailyTemperatures(T: IntArray): IntArray {
        val stack = mutableListOf<Pair<Int, Int>>()

        val rst = mutableListOf<Pair<Int, Int>>()
        for ((i, v) in T.withIndex()) {
            while (!stack.isEmpty()) {
                val last = stack.last()
                if (v > last.second) {
                    stack.removeAt(stack.lastIndex)
                    rst.add(Pair(last.first, i - last.first))
                } else {
                    break
                }
            }
            stack.add(Pair(i, v))
        }
        for ((i, _) in stack) {
            rst.add(Pair(i, 0))
        }
        rst.sortBy { it.first }
        return rst.map { it.second }.toIntArray()
    }
}

fun main() {
    println(Solution739().dailyTemperatures(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)).toList())
}