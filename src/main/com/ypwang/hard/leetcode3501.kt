package com.ypwang.hard

class Solution3501 {
    fun maxActiveSectionsAfterTrade(s: String, queries: Array<IntArray>): List<Int> {
        val n = s.length
        var activeCount = s.count { it == '1' }

        val segments = mutableListOf<Pair<Int, Int>>()
        var start = 0
        for (i in 0 until n) {
            if (i == n - 1 || s[i] != s[i + 1]) {
                segments.add(start to (i - start + 1))
                start = i + 1
            }
        }
        val segmentCount = segments.size

        val maxPower = 20
        val INF = 1e9.toInt()
        val NEG_INF = -INF
        val rmq = Array(maxPower) { IntArray(segmentCount) { NEG_INF } }

        for (i in 0 until segmentCount)
            if (s[segments[i].first] == '0' && i + 2 < segmentCount)
                rmq[0][i] = segments[i].second + segments[i + 2].second

        var rangeLen = 2
        for (power in 1 until maxPower) {
            for (i in 0 until segmentCount - rangeLen + 1) {
                rmq[power][i] = maxOf(rmq[power - 1][i], rmq[power - 1][i + rangeLen / 2])
            }
            rangeLen *= 2
        }

        return queries.map { (left, right) ->
            val leftIndex = binarySearch(segments, left) - 1
            val rightIndex = binarySearch(segments, right) - 1

            activeCount +
                    if (rightIndex - leftIndex + 1 <= 2) 0
                    else maxOf(
                        0,
                        getMaxInRange(rmq, leftIndex + 1, rightIndex - 3, NEG_INF),
                        calculateNewSections(s, segments, left, right, leftIndex, rightIndex, leftIndex, NEG_INF),
                        calculateNewSections(s, segments, left, right, leftIndex, rightIndex, rightIndex - 2, NEG_INF)
                    )
        }
    }

    private fun binarySearch(segments: List<Pair<Int, Int>>, key: Int): Int {
        var lo = 0
        var hi = segments.size
        while (lo < hi) {
            val mid = lo + (hi - lo) / 2
            if (segments[mid].first > key)
                hi = mid
            else
                lo = mid + 1
        }
        return lo
    }

    private fun getMaxInRange(rmq: Array<IntArray>, left: Int, right: Int, NEG_INF: Int): Int {
        if (left > right) return NEG_INF
        val power = 31 - Integer.numberOfLeadingZeros(right - left + 1)
        return maxOf(rmq[power][left], rmq[power][right - (1 shl power) + 1])
    }

    private fun getSegmentSize(
        segments: List<Pair<Int, Int>>,
        left: Int,
        right: Int,
        leftIndex: Int,
        rightIndex: Int,
        i: Int
    ): Int =
        when (i) {
            leftIndex -> segments[leftIndex].second - (left - segments[leftIndex].first)
            rightIndex -> right - segments[rightIndex].first + 1
            else -> segments[i].second
        }

    private fun calculateNewSections(
        s: String,
        segments: List<Pair<Int, Int>>,
        left: Int,
        right: Int,
        leftIndex: Int,
        rightIndex: Int,
        i: Int,
        NEG_INF: Int
    ): Int {
        if (i < 0 || i + 2 >= segments.size || s[segments[i].first] == '1') return NEG_INF
        val size1 = getSegmentSize(segments, left, right, leftIndex, rightIndex, i)
        val size2 = getSegmentSize(segments, left, right, leftIndex, rightIndex, i + 2)
        return size1 + size2
    }
}
