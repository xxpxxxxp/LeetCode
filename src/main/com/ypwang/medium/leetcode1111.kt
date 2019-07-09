package com.ypwang.medium

class Solution1111 {
    fun maxDepthAfterSplit(seq: String): IntArray {
        var depth = 0
        var count = 0

        for (c in seq) {
            when (c) {
                '(' -> {
                    count++
                    if (count > depth) depth = count
                }
                ')' -> count--
            }
        }

        var min = depth / 2

        val rst = IntArray(seq.length)
        count = 0

        for ((i, c) in seq.withIndex()) {
            when (c) {
                '(' -> {
                    count++
                    if (count > min) rst[i] = 1
                }
                ')' -> {
                    if (count > min) rst[i] = 1
                    count--
                }
            }
        }

        return rst
    }
}

fun main() {
    println(Solution1111().maxDepthAfterSplit("()(())()").toList())
}