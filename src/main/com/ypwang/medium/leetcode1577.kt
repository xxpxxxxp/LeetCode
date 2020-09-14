package com.ypwang.medium

class Solution1577 {
    private fun calc(l1: List<Pair<Int, Int>>, m2: Map<Int, Int>): Int =
            l1.map { (v, c) ->
                val square = 1L * v * v
                m2.map { (v2, c2) ->
                    if (square % v2 == 0L) {
                        val div = (square / v2).toInt()
                        if (div.toLong() * v2 == square && div in m2) {
                            if (v2 == v) c2 * (c2 - 1)
                            else c2 * m2[div]!!
                        } else 0
                    } else 0
                }.sum() * c / 2
            }.sum()

    fun numTriplets(nums1: IntArray, nums2: IntArray): Int {
        val m1 = nums1.groupBy{ it }.mapValues{ it.value.size }
        val g1 = m1.toList().sortedBy { it.first }
        val m2 = nums2.groupBy{ it }.mapValues{ it.value.size }
        val g2 = m2.toList().sortedBy { it.first }

        return calc(g1, m2) + calc(g2, m1)
    }
}