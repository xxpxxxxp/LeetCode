package com.ypwang.medium

class Solution2271 {
    fun maximumWhiteTiles(tiles: Array<IntArray>, carpetLen: Int): Int {
        tiles.sortBy { it[0] }
        val startPos = tiles.map { it[0] }
        val preSum = IntArray(tiles.size + 1)
        for ((i, arr) in tiles.withIndex())
            preSum[i+1] = preSum[i] + (arr[1] - arr[0] + 1)

        var rst = 0
        for ((i, arr) in tiles.withIndex()) {
            val (s, e) = arr
            val end = s + carpetLen - 1
            if (e >= end)
                return carpetLen

            val endIdx = startPos.binarySearch(end).let {
                if (it < 0) -it-2
                else it
            }

            var compensate = 0
            if (tiles[endIdx][1] > end)
                compensate = tiles[endIdx][1] - end

            rst = maxOf(rst, preSum[endIdx+1] - preSum[i] - compensate)
        }

        return rst
    }
}

fun main() {
    println(Solution2271().maximumWhiteTiles(arrayOf(
        intArrayOf(1,1), intArrayOf(2,2), intArrayOf(5,5)
    ), 2))
}