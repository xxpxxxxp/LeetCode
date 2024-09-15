package com.ypwang.hard

class Solution3288 {
    fun maxPathLength(coordinates: Array<IntArray>, k: Int): Int {
        val n = coordinates.size
        val (ncx, ncy) = coordinates[k]

        coordinates.sortWith(compareBy<IntArray> { it[0] }.thenByDescending { it[1] })

        val coordinates1 = mutableListOf<Int>()
        val coordinates2 = mutableListOf<Int>()

        for ((x, y) in coordinates) {
            if (x < ncx && y < ncy)
                coordinates1.add(y)
            if (x > ncx && y > ncy)
                coordinates2.add(y)
        }

        return calculateLIS(coordinates1) + calculateLIS(coordinates2) + 1
    }

    private fun calculateLIS(coordinates: List<Int>): Int {
        val dp = IntArray(coordinates.size)
        var size = 0
        for (y in coordinates) {
            val pos = dp.binarySearch(y, 0, size).let { if (it < 0) -it-1 else it }
            dp[pos] = y
            if (pos == size)
                size++
        }
        return size
    }
}

fun main() {
    println(Solution3288().maxPathLength(arrayOf(
        intArrayOf(3,1),
        intArrayOf(2,2),
        intArrayOf(4,1),
        intArrayOf(0,0),
        intArrayOf(5,3),
    ), 1))
}