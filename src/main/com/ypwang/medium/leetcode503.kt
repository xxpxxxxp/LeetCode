package com.ypwang.medium

import java.util.*

class Solution503 {
    fun nextGreaterElements(nums: IntArray): IntArray {
        val stack = Stack<IndexedValue<Int>>()
        val rst = mutableListOf<IndexedValue<Int>>()

        var push = true
        for (i in 0..1) {
            for (iv in nums.withIndex()) {
                while (!stack.empty() && iv.value > stack.peek().value) {
                    val last = stack.pop()
                    rst.add(IndexedValue(last.index, iv.value))
                }
                if (push) {
                    stack.push(iv)
                }

            }

            push = false
        }

        for (iv in stack) {
            rst.add(IndexedValue(iv.index, -1))
        }

        rst.sortBy { it.index }
        return rst.map { it.value }.toIntArray()
    }
}

fun main(args: Array<String>) {
    println(Solution503().nextGreaterElements(intArrayOf(1,2,1)).toList())
}