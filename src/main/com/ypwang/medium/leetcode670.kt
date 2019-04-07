package com.ypwang.medium

class Solution670 {
    fun maximumSwap(num: Int): Int {
        var swap = Pair(-1, -1)

        val n = num.toString().map { it - '0' }.toTypedArray()
        var max = Int.MIN_VALUE
        var index = -1

        for (i in n.lastIndex downTo 0) {
            if (n[i] < max) {
                swap = Pair(i, index)
            } else if (n[i] > max) {
                max = n[i]
                index = i
            }
        }

        if (swap.second != -1) {
            val t = n[swap.first]
            n[swap.first] = n[swap.second]
            n[swap.second] = t
        }

        return n.joinToString("").toInt()
    }
}

fun main() {
    println(Solution670().maximumSwap(9973))
}