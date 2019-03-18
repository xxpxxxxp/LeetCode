package com.ypwang.medium

class Solution313 {
    fun nthSuperUglyNumber(n: Int, primes: IntArray): Int {
        val rst = Array(n){1}
        val pindex = IntArray(primes.size){0}.zip(primes).toTypedArray()

        for (i in 1 until n) {
            rst[i] = pindex.map { rst[it.first] * it.second }.min()!!

            for ((index, p) in pindex.withIndex()) {
                if (rst[i] == rst[p.first] * p.second) {
                    pindex[index] = Pair(p.first + 1, p.second)
                }
            }
        }

        return rst.last()
    }
}

fun main() {
    println(Solution313().nthSuperUglyNumber(12, intArrayOf(2,7,13,19)))
}