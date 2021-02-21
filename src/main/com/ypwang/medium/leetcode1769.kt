package com.ypwang.medium

class Solution1769 {
    fun minOperations(boxes: String): IntArray {
        var total = 0
        var steps = 0

        for ((i, c) in boxes.withIndex()) {
            if (c == '1') {
                total++
                steps += i
            }
        }

        val rst = IntArray(boxes.length)
        rst[0] = steps
        var left = boxes[0] - '0'
        for (i in 1 until boxes.length) {
            steps += 2 * left - total
            rst[i] = steps

            if (boxes[i] == '1') {
                left++
            }
        }

        return rst
    }
}

fun main() {
    println(Solution1769().minOperations("110").toList())
    println(Solution1769().minOperations("001011").toList())
}