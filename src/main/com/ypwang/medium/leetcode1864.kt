package com.ypwang.medium

class Solution1864 {
    private fun diff(idx1: Iterable<Int>, idx2: Iterable<Int>): Int =
        idx1.toSet().let { it.size - it.intersect(idx2.toSet()).size }

    fun minSwaps(s: String): Int {
        val c1 = s.count { it == '1' }
        if (s.length !in (2 * c1 - 1)..(2 * c1 + 1))
            return -1

        return s.withIndex()
            .filter { it.value == '1' }
            .map { it.index }
            .let {
                if (s.length % 2 == 0) {
                    minOf(diff(it, (s.indices step 2)), diff(it, (1 until s.length step 2)))
                } else {
                    if (2 * c1 - 1 == s.length)
                        diff(it, (s.indices step 2))
                    else
                        diff(it, (1 until s.length step 2))
                }
            }
    }
}

fun main() {
    println(Solution1864().minSwaps("111000"))
    println(Solution1864().minSwaps("010"))
    println(Solution1864().minSwaps("1110"))
}