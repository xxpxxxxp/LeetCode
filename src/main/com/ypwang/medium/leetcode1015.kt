package com.ypwang.medium

class Solution1015 {
    fun smallestRepunitDivByK(K: Int): Int {
        if (K == 2 || K == 5)
            return -1

        var count = 1
        var m = 1
        for (i in 0 until K) {
            if (m % K == 0)
                return count

            m = (m * 10 + 1) % K
            count++
        }
        return -1
    }
}

fun main() {
    println(Solution1015().smallestRepunitDivByK(15))
}