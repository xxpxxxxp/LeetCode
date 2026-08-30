package com.ypwang.medium

class Solution4034 {
    fun minBishopMoves(source: IntArray, target: IntArray): Int {
        val (sr, sc) = source
        val (tr, tc) = target

        // Bishop cannot change square color
        if ((sr + sc) % 2 != (tr + tc) % 2)
            return -1

        // Same diagonal
        if (Math.abs(sr - tr) == Math.abs(sc - tc))
            return 1

        // Same color, different diagonal
        return 2
    }
}
