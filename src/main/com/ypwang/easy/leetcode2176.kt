package com.ypwang.easy

class Solution2176 {
    fun countPairs(nums: IntArray, k: Int): Int =
        nums.withIndex()
            .groupBy { it.value }
            .map { it.value.map { i -> i.index } }
            .map { l ->
                var c = 0
                for (i in l.indices) {
                    for (j in i+1 until l.size) {
                        if ((l[i] * l[j]) % k == 0)
                            c++
                    }
                }
                c
            }.sum()
}

fun main() {
    println(Solution2176().countPairs(intArrayOf(3,1,2,2,2,1,3), 2))
}