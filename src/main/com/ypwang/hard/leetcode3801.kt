package com.ypwang.hard

class Solution3801 {
    // Equivalent of Rust's partition_point(|v| v < guess)
    private fun countLessThan(arr: IntArray, guess: Int): Int {
        var l = 0
        var r = arr.size
        while (l < r) {
            val m = (l + r) / 2
            if (arr[m] < guess)
                l = m + 1
            else
                r = m
        }
        return l
    }

    private fun numLt(lists: Array<IntArray>, enabled: Int, guess: Int): Int {
        var result = 0
        for (i in lists.indices)
            if (((enabled shr i) and 1) == 1)
                result += countLessThan(lists[i], guess)

        return result
    }

    fun minMergeCost(lists: Array<IntArray>): Long {
        val n = lists.size

        // Collect all numbers
        val allNums = lists.flatMap { it.toList() }.sorted()

        // subsets[mask] = Pair(length, median)
        val subsets = ArrayList<Pair<Long, Long>>()
        subsets.add(0L to 0L) // mask = 0

        for (subset in 1 until (1 shl n)) {
            var resultLen = 0
            for (i in 0 until n) {
                if (((subset shr i) and 1) == 1) {
                    resultLen += lists[i].size
                }
            }

            val medianLt = (resultLen - 1) / 2

            var low = 0
            var high = allNums.size - 1
            var actualMedian = -1

            while (low <= high) {
                val mid = (low + high) ushr 1
                val num = allNums[mid]
                val cnt = numLt(lists, subset, num)

                if (cnt <= medianLt) {
                    actualMedian = num
                    low = mid + 1
                } else {
                    high = mid - 1
                }
            }

            subsets.add(resultLen.toLong() to actualMedian.toLong())
        }

        val size = 1 shl n
        val dp = LongArray(size) { Long.MAX_VALUE }

        for (subset in 0 until size) {
            if (Integer.bitCount(subset) <= 1) {
                dp[subset] = 0L
            } else {
                var a = (subset - 1) and subset
                while (a > 0) {
                    val b = subset xor a
                    val (lenA, medA) = subsets[a]
                    val (lenB, medB) = subsets[b]
                    val cost = lenA + lenB + Math.abs(medA - medB)
                    dp[subset] = minOf(dp[subset], dp[a] + dp[b] + cost)
                    a = (a - 1) and subset
                }
            }
        }

        return dp[size - 1]
    }
}
