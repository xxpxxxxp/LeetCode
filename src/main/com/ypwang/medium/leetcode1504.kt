package com.ypwang.medium

import java.util.*

class Solution1504 {
    fun numSubmat(mat: Array<IntArray>): Int {
        val height = IntArray(mat[0].size)
        val sum = IntArray(mat[0].size)
        val stack = Stack<Int>()

        var rst = 0

        for (row in mat) {
            stack.clear()
            sum.fill(0)
            for ((i, v) in row.withIndex()) {
                if (v == 1) height[i]++ else height[i] = 0

                while (stack.isNotEmpty() && height[stack.peek()] >= height[i]) {
                    stack.pop()
                }

                if (stack.isNotEmpty()) {
                    val idx = stack.peek()
                    sum[i] = sum[idx] + height[i] * (i - idx)
                } else {
                    sum[i] = height[i] * (i + 1);
                }

                rst += sum[i]
                stack.push(i)
            }
        }

        return rst
    }
}

fun main() {
    println(Solution1504().numSubmat(arrayOf(
            intArrayOf(0,1,1,1), intArrayOf(1,1,0,1), intArrayOf(1,1,0,0), intArrayOf(1,1,1,1), intArrayOf(0,1,0,0)
    )))
    println(Solution1504().numSubmat(arrayOf(
            intArrayOf(1,0,1), intArrayOf(1,1,0), intArrayOf(1,1,0)
    )))
    println(Solution1504().numSubmat(arrayOf(
            intArrayOf(0,1,1,0), intArrayOf(0,1,1,1), intArrayOf(1,1,1,0)
    )))
    println(Solution1504().numSubmat(arrayOf(
            intArrayOf(1,1,1,1,1,1)
    )))
    println(Solution1504().numSubmat(arrayOf(
            intArrayOf(1,0,1), intArrayOf(0,1,0), intArrayOf(1,0,1)
    )))
}