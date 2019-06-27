package com.ypwang.hard

class Solution805 {
    fun splitArraySameAverage(A: IntArray): Boolean {
        val sum = A.sum()
        val target = (1..A.size).filter { it * sum % A.size == 0 }.map { it to it * sum / A.size }.toMap()

        val sums = mutableMapOf(0 to mutableSetOf(0))

        for ((i, a) in A.withIndex()) {
            for (j in i downTo 0) {
                if (j+1 !in sums) sums[j+1] = mutableSetOf()
                sums[j+1]!!.addAll(sums[j]!!.map { it + a })

                if (j+1 != A.size && j+1 in target && target[j+1] in sums[j+1]!!) return true
            }
        }

        return false
    }
}

fun main() {
    println(Solution805().splitArraySameAverage(intArrayOf(3,1)))
}