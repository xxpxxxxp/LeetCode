package com.ypwang.medium

class Solution2768 {
    fun countBlackBlocks(m: Int, n: Int, coordinates: Array<IntArray>): LongArray {
        val countMap = mutableMapOf<Long, Int>()
        val rst = LongArray(5)
        for ((x, y) in coordinates) {
            for ((dx, dy) in listOf(0 to 0, 0 to 1, 1 to 0, 1 to 1)) {
                if (x - dx >= 0 && y - dy >= 0 && x - dx < m - 1 && y - dy < n - 1) {
                    val key = (x - dx).toLong() * n + y - dy
                    countMap[key] = countMap.getOrDefault(key, 0) + 1
                }
            }
        }

        for (count in countMap.values)
            rst[count] = rst[count] + 1
        rst[0] = 1L * (m - 1) * (n - 1) - rst.sum()
        return rst
    }
}