package com.ypwang.hard

class Solution3464 {
    // Map a boundary point (x,y) to a coordinate in [0, 4*side)
    fun mapPoint(side: Int, x: Int, y: Int): Long {
        return when {
            y == 0 -> x.toLong()
            x == side -> side.toLong() + y
            y == side -> 3L * side - x
            else -> 4L * side - y
        }
    }

    // Given sorted 1D positions t (mapped from points) and candidate distance d,
    // check if we can select k points around the circle (perimeter L = 4*side)
    // so that every adjacent gap (in circular order) is at least d.
    fun canPlace(ext: LongArray, n: Int, k: Int, side: Int, d: Int): Boolean {
        // For each possible starting index i (in the original sorted array)
        for (i in 0 until n) {
            var count = 1
            var pos = ext[i]
            var idx = i
            // We only consider indices up to i+n (i.e. one full circle).
            for (cnt in 1 until k) {
                val target = pos + d
                // lower_bound in ext[idx+1, ext.begin()+i+n)
                val next = ext.binarySearch(target, idx+1, i+n).let {
                    if (it < 0) -it-1 else it
                }
                if (next >= i+n) {
                    count = -1 // not enough points available from this start
                    break
                }
                idx = next
                pos = ext[idx]
                count++
            }
            // After selecting k points, check the wrap–around gap:
            // The gap from the last chosen point (at pos) to (first + L) must be at least d.
            if (count == k && (ext[i] + 4L * side - pos) >= d) return true
        }
        return false
    }

    fun maxDistance(side: Int, points: Array<IntArray>, k: Int): Int {
        val t = LongArray(points.size) {
            val (x, y) = points[it]
            mapPoint(side, x, y)
        }
        t.sort()

        val L = 4L * side
        // Build an "extended" array: ext[i] = t[i] for i in [0, n) and ext[i+n] = t[i] + L.
        val ext = LongArray(2 * points.size)
        for (i in t.indices) {
            ext[i] = t[i]
            ext[i + t.size] = t[i] + L
        }

        // Binary search candidate d in [0, 2*side].
        var lo = 0
        var hi = 2 * side
        while (lo < hi) {
            val mid = (lo + hi + 1) / 2
            if (canPlace(ext, points.size, k, side, mid))
                lo = mid
            else
                hi = mid - 1
        }
        return lo
    }
}

fun main() {
    println(Solution3464().maxDistance(2, arrayOf(
        intArrayOf(0,0),intArrayOf(1,2),intArrayOf(2,0),intArrayOf(2,2),intArrayOf(2,1)
    ), 4))
}
