package com.ypwang.hard

class Solution3102 {
    fun minimumDistance(points: Array<IntArray>): Int {
        fun maxDistance(skipIndex: Int = -1): Triple<Int, Int, Int> {
            val sum = intArrayOf(Int.MAX_VALUE, Int.MIN_VALUE)
            val sumIndices = intArrayOf(0, 0)
            val diff = intArrayOf(Int.MAX_VALUE, Int.MIN_VALUE)
            val diffIndices = intArrayOf(0, 0)

            for (i in points.indices) {
                if (i == skipIndex)
                    continue

                val (x, y) = points[i]

                if (sum[0] > x + y) {
                    sum[0] = x + y
                    sumIndices[0] = i
                }

                if (sum[1] < x + y) {
                    sum[1] = x + y
                    sumIndices[1] = i
                }

                if (diff[0] > x - y) {
                    diff[0] = x - y
                    diffIndices[0] = i
                }

                if (diff[1] < x - y) {
                    diff[1] = x - y
                    diffIndices[1] = i
                }
            }

            return if (sum[1] - sum[0] > diff[1] - diff[0]) {
                Triple(sum[1] - sum[0], sumIndices[0], sumIndices[1])
            } else {
                Triple(diff[1] - diff[0], diffIndices[0], diffIndices[1])
            }
        }

        val (_, i, j) = maxDistance()
        return minOf(maxDistance(i).first, maxDistance(j).first)
    }
}
