package com.ypwang.easy

class Solution1175 {
    fun numPrimeArrangements(n: Int): Int {
        val a = BooleanArray(n)
        a[0] = true

        var i = 1
        while (i < n) {
            if (!a[i]) {
                val cur = i + 1
                var factor = 2
                while (cur * factor <= n) {
                    a[cur * factor - 1] = true
                    factor++
                }
            }
            i++
        }

        var m = a.count { it }
        var n = a.size - m

        var rst = 1L
        while (m > 0) {
            rst = (rst * m) % 1000000007
            m--
        }
        while (n > 0) {
            rst = (rst * n) % 1000000007
            n--
        }
        return rst.toInt()
    }
}

fun main() {
    println(Solution1175().numPrimeArrangements(5))
    println(Solution1175().numPrimeArrangements(100))
}