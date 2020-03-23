package com.ypwang.medium

class Solution1387 {
    private fun step(i: Int): Int {
        var step = 0
        var j = i
        while (j != 1) {
            if (j % 2 == 0) j /= 2 else j = 3 * j + 1
            step++
        }

        return step
    }

    fun getKth(lo: Int, hi: Int, k: Int): Int = (lo..hi).map { it to step(it) }.sortedBy { it.second }[k-1].first
}

fun main() {
    println(Solution1387().getKth(12, 15, 2))
}