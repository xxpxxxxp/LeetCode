package com.ypwang.medium

class Solution646 {
    fun findLongestChain(pairs: Array<IntArray>): Int {
        pairs.sortBy { it[0] }
        val rst = IntArray(pairs.size){1}

        for (i in 1 until pairs.size) {
            for (j in 0 until i) {
                if (pairs[j][1] < pairs[i][0]) {
                    rst[i] = Math.max(rst[i], rst[j] + 1)
                }
            }
        }

        return rst.max()!!
    }
}

fun main() {
    println(Solution646().findLongestChain(
            arrayOf(
                    intArrayOf(1,2),
                    intArrayOf(2,3),
                    intArrayOf(3,4)
            )
    ))
}