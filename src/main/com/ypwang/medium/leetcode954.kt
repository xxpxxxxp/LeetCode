package com.ypwang.medium

class Solution954 {
    fun canReorderDoubled(A: IntArray): Boolean {
        if (A.isEmpty())
            return true

        val sorted = A.sortedBy { Math.abs(it) }
        val count = A.groupBy { it }.mapValues { it.value.size }.toMutableMap()

        for (x in sorted) {
            if (count[x] == 0) continue
            if (count.getOrDefault(2 * x, 0) <= 0) return false

            count[x] = count[x]!! - 1
            count[2 * x] = count.getOrDefault(2 * x, 0) - 1
        }

        return true
    }
}

fun main() {
    println(Solution954().canReorderDoubled(intArrayOf(1,2,1,-8,8,-4,4,-4,2,-2)))
}