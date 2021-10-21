package com.ypwang.medium

class Solution1584 {
    fun minCostConnectPoints(points: Array<IntArray>): Int {
        val seen = mutableSetOf<Int>()
        val dis = IntArray(points.size){ Int.MAX_VALUE }

        var rst = 0
        var idx = 0

        fun update(i: Int) {
            seen.add(i)
            dis[i] = Int.MAX_VALUE

            for (j in points.indices) {
                if (j !in seen)
                    dis[j] = minOf(dis[j], Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]))

            }
        }

        update(idx)
        while (seen.size != points.size) {
            val next = dis.withIndex().minByOrNull{ it.value }!!
            rst += next.value
            idx = next.index
            update(idx)
        }

        return rst
    }
}