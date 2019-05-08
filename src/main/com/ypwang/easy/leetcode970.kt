package com.ypwang.easy

class Solution970 {
    fun powerfulIntegers(x: Int, y: Int, bound: Int): List<Int> {
        val xr = mutableListOf(1)
        val yr = mutableListOf(1)

        while (true) {
            val t = xr.last() * x
            if (t == xr.last() || t > bound) break
            xr.add(t)
        }

        while (true) {
            val t = yr.last() * y
            if (t == yr.last() || t > bound) break
            yr.add(t)
        }

        val rst = mutableSetOf<Int>()
        for (i in xr) {
            for (j in yr) {
                if (i + j <= bound) rst.add(i+j)
                else break
            }
        }

        return rst.toList()
    }
}

fun main() {
    println(Solution970().powerfulIntegers(2, 3, 10))
}