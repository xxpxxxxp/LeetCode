package com.ypwang.hard

class Solution1982 {
    private fun helper(n: Int, sums: List<Int>): List<Int> {
        if (n == 1 && sums.contains(0))
            return listOf(sums.maxBy { Math.abs(it) }!!)

        val d = sums[1] - sums[0]
        val candidates = mutableListOf<List<Int>>()
        label@ for (dr in listOf(1, -1)) {
            val counter = sums.groupBy { it }.mapValues { it.value.size }.toMutableMap()
            if (0 !in counter)
                return listOf()

            val take = if (dr > 0) sums else sums.reversed()
            val next = mutableListOf<Int>()

            for (num in take) {
                if (counter[num] == 0)
                    continue

                if (counter[num + d*dr] == 0)
                    continue@label

                counter[num] = counter[num]!! - 1
                counter[num + d*dr] = counter[num + d * dr]!! - 1
                next.add(num)
            }

            if (dr < 0)
                next.reverse()

            candidates.add(listOf(d*dr) + helper(n-1, next))
        }

        return candidates.maxBy { it.size }!!
    }

    fun recoverArray(n: Int, sums: IntArray): IntArray {
        sums.sort()
        return helper(n, sums.toList()).toIntArray()
    }
}

fun main() {
    println(Solution1982().recoverArray(4, intArrayOf(0,0,5,5,4,-1,4,9,9,-1,4,3,4,8,3,8)).toList())
    println(Solution1982().recoverArray(3, intArrayOf(-3,-2,-1,0,0,1,2,3)).toList())
    println(Solution1982().recoverArray(2, intArrayOf(0,0,0,0)).toList())
}