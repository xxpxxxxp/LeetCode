package com.ypwang.medium

class Solution2698 {
    fun punishmentNumber(n: Int): Int =
        (1..n).filter { check(0, it, 0, (it * it).toString()) }.map { it * it }.sum()!!

    fun check(idx: Int, n: Int, s: Int, s1: String): Boolean {
        if (idx == s1.length)
            return s == n

        for (j in idx until s1.length) {
            if (check(j + 1, n, s + s1.substring(idx, j + 1).toInt(), s1))
                return true
        }
        return false
    }
}