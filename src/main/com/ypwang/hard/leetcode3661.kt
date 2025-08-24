package com.ypwang.hard

import java.util.*
import kotlin.math.max
import kotlin.math.min

class Solution3661 {
    fun maxWalls(robots: IntArray, distance: IntArray, walls: IntArray): Int {
        val n = robots.size

        // Pair robots with distances and sort
        val rpair = Array<IntArray?>(n) { IntArray(2) }
        for (i in 0..<n) {
            rpair[i]!![0] = robots[i]
            rpair[i]!![1] = distance[i]
        }
        Arrays.sort<IntArray?>(rpair, Comparator { a: IntArray?, b: IntArray? -> Integer.compare(a!![0], b!![0]) })
        val r = IntArray(n)
        val d = IntArray(n)
        for (i in 0..<n) {
            r[i] = rpair[i]!![0]
            d[i] = rpair[i]!![1]
        }

        Arrays.sort(walls)

        // Count walls at robot positions
        var base = 0
        for (i in 0..<n) {
            val idx = Arrays.binarySearch(walls, r[i])
            if (idx >= 0) base++
        }

        // Tail walls
        val leftTail = countRange(walls, (r[0] - d[0]).toLong(), (r[0] - 1).toLong())
        val rightTail = countRange(walls, (r[n - 1] + 1).toLong(), (r[n - 1] + d[n - 1]).toLong())

        // Precompute segment ranges
        val segs = n - 1
        val A = IntArray(max(0, segs))
        val B = IntArray(max(0, segs))
        val C = IntArray(max(0, segs))
        for (i in 0..<segs) {
            val segL = r[i] + 1
            val segR = r[i + 1] - 1
            if (segL > segR) {
                C[i] = 0
                B[i] = C[i]
                A[i] = B[i]
                continue
            }
            val A_high = min(segR, r[i] + d[i])
            A[i] = countRange(walls, segL.toLong(), A_high.toLong())

            val B_low = max(segL, r[i + 1] - d[i + 1])
            B[i] = countRange(walls, B_low.toLong(), segR.toLong())

            val C_low = max(segL, r[i + 1] - d[i + 1])
            val C_high = min(segR, r[i] + d[i])
            C[i] = countRange(walls, C_low.toLong(), C_high.toLong())
        }

        // DP initialization
        val dp = Array<IntArray?>(n) { IntArray(2) }
        Arrays.fill(dp[0], Int.Companion.MIN_VALUE / 4)
        dp[0]!![0] = base + leftTail // first fires left
        dp[0]!![1] = base // first fires right

        // DP transitions
        for (i in 0..<n - 1) {
            Arrays.fill(dp[i + 1], Int.Companion.MIN_VALUE / 4)
            for (choice in 0..1) {
                val cur = dp[i]!![choice]
                if (cur < 0) continue

                // Next fires left
                val addIfNextLeft = if (choice == 1)
                    A[i] + B[i] - C[i]
                else
                    B[i]
                dp[i + 1]!![0] = max(dp[i + 1]!![0], cur + addIfNextLeft)

                // Next fires right
                val addIfNextRight = if (choice == 1) A[i] else 0
                dp[i + 1]!![1] = max(dp[i + 1]!![1], cur + addIfNextRight)
            }
        }

        // Final result
        val res: Int
        if (n == 1) {
            res = max(dp[0]!![0], dp[0]!![1] + rightTail)
        } else {
            res = max(dp[n - 1]!![0], dp[n - 1]!![1] + rightTail)
        }
        return res
    }

    companion object {
        // Count walls in range [L, R]
        private fun countRange(arr: IntArray, L: Long, R: Long): Int {
            if (L > R || arr.size == 0) return 0
            val leftIdx = lowerBound(arr, L)
            val rightIdx = upperBound(arr, R)
            return max(0, rightIdx - leftIdx)
        }

        private fun lowerBound(a: IntArray, x: Long): Int {
            var l = 0
            var r = a.size
            while (l < r) {
                val m = (l + r) ushr 1
                if (a[m] < x) l = m + 1
                else r = m
            }
            return l
        }

        private fun upperBound(a: IntArray, x: Long): Int {
            var l = 0
            var r = a.size
            while (l < r) {
                val m = (l + r) ushr 1
                if (a[m] <= x) l = m + 1
                else r = m
            }
            return l
        }
    }
}
