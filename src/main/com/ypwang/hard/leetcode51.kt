package com.ypwang.hard

import java.lang.StringBuilder
import kotlin.math.abs

class Solution51 {
    fun solveNQueens(n: Int): List<List<String>> {
        val rst = mutableListOf<List<String>>()

        fun backTracing(current: MutableList<Int>) {
            if (current.size == n) {
                rst.add(current.map {
                    StringBuilder().apply {
                        for (i in 0 until it) append('.')
                        append('Q')
                        for (i in it+1 until n) append('.')
                    }.toString()
                })
            }

            for (i in 0 until n) {
                if (current.withIndex().all { it.value != i && abs(current.size - it.index) != abs(i - it.value) }) {
                    current.add(i)
                    backTracing(current)
                    current.removeAt(current.lastIndex)
                }
            }
        }

        (0 until n).map { backTracing(mutableListOf(it)) }

        return rst
    }
}

fun main() {
    println(Solution51().solveNQueens(4))
}