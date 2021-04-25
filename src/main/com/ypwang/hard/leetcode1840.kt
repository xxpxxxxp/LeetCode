package com.ypwang.hard

class Solution1840 {
    fun maxBuilding(n: Int, restrictions: Array<IntArray>): Int {
        restrictions.sortBy { it[0] }
        val copy = Array(restrictions.size+2) {
            when (it) {
                0 -> intArrayOf(1, 0)
                restrictions.size+1 -> intArrayOf(n, n-1)
                else -> restrictions[it-1]
            }
        }

        for (i in 1 until copy.size)
            copy[i][1] = minOf(copy[i][1], copy[i-1][1] + copy[i][0] - copy[i-1][0])

        for (i in copy.size-2 downTo 0)
            copy[i][1] = minOf(copy[i][1], copy[i+1][1] + copy[i+1][0] - copy[i][0])

        var rst = 0
        for (i in 1 until copy.size) {
            val (l, h1) = copy[i-1]
            val (r, h2) = copy[i]
            rst = maxOf(rst, maxOf(h1, h2) + (r - l - Math.abs(h1 - h2)) / 2)
        }

        return rst
    }
}