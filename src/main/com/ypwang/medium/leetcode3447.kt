package com.ypwang.medium

class Solution3447 {
    fun assignElements(groups: IntArray, elements: IntArray): IntArray {
        val choice = mutableMapOf<Int, Int>()
        for ((i, n) in elements.withIndex()) {
            if (n !in choice)
                choice[n] = i
        }

        val rst = IntArray(groups.size) { Int.MAX_VALUE }
        for ((i, n) in groups.withIndex()) {
            for (j in 1 .. Math.sqrt(n.toDouble()).toInt()) {
                if (n % j == 0) {
                    if (j in choice)
                        rst[i] = minOf(rst[i], choice[j]!!)
                    if (n / j in choice)
                        rst[i] = minOf(rst[i], choice[n / j]!!)
                }
            }

            if (rst[i] == Int.MAX_VALUE)
                rst[i] = -1
        }

        return rst
    }
}

fun main() {
    println(Solution3447().assignElements(intArrayOf(8,4,3,2,4), intArrayOf(4,2)).toList())
}