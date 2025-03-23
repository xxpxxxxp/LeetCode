package com.ypwang.hard

class Solution3495 {
    fun minOperations(queries: Array<IntArray>): Long {
        var rst = 0L
        for ((l, r) in queries) {
            var sum = 0L
            var p = 1L
            var p4 = 1

            while (p4 <= r) { // 1, 4, 16, 64, ...
                val pl = maxOf(l, p4)
                val pr = minOf(r, p4 * 4 - 1)
                if (pr >= pl)
                    sum += p * (pr - pl + 1)

                p++
                p4 *= 4
            }
            rst += (sum + 1) / 2
        }
        return rst
    }
}

fun main() {
    println(Solution3495().minOperations(arrayOf(intArrayOf(5,8))))
}