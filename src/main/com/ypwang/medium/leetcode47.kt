package com.ypwang.medium

class Solution47 {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val map = nums.groupBy { it }.mapValues { it.value.size }.toMutableMap()

        val rst = mutableListOf<List<Int>>()
        val stack = mutableListOf<Int>()

        fun backtrace() {
            if (stack.size == nums.size) {
                rst.add(stack.toList())
            } else {
                for ((v, c) in map.filter { it.value > 0 }) {
                    stack.add(v)
                    map[v] = c - 1
                    backtrace()
                    map[v] = c
                    stack.removeAt(stack.lastIndex)
                }
            }
        }

        backtrace()
        return rst
    }
}

fun main(args: Array<String>) {
    println(Solution47().permuteUnique(intArrayOf(1,1,2,2,3,3,4)).size)
}