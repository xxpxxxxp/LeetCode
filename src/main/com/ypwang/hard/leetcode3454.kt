package com.ypwang.hard

class Solution3454 {
    fun separateSquares(squares: Array<IntArray>): Double {
        val N = squares.size
        val m = 2 * N  // each square produces two events.
        val events = Array(m) { Event(0.0, 0.0, 0.0, 0) }
        val xsRaw = DoubleArray(m)
        var eIdx = 0
        var xIdx = 0

        for (sq in squares) {
            val x = sq[0].toDouble()
            val y = sq[1].toDouble()
            val l = sq[2].toDouble()
            val x2 = x + l
            val y2 = y + l
            events[eIdx++] = Event(y, x, x2, 1)
            events[eIdx++] = Event(y2, x, x2, -1)
            xsRaw[xIdx++] = x
            xsRaw[xIdx++] = x2
        }

        // Sort events by y.
        events.sortBy { it.y }

        // Compress x–coordinates.
        val xs = compress(xsRaw)

        // Build segment tree over compressed x.
        val st = SegmentTree(xs)

        // Sweep once and build piecewise linear segments:
        // Each segment covers an interval [yStart, yEnd] where the union x–length is constant.
        val segs = mutableListOf<SweepSegment>()
        var cumArea = 0.0
        var prevY = events[0].y
        var i = 0

        while (i < m) {
            val curY = events[i].y
            if (curY > prevY) {
                val unionX = st.query()
                // Record segment from prevY to curY with union length unionX
                segs.add(SweepSegment(prevY, curY, cumArea, unionX))
                cumArea += unionX * (curY - prevY)
                prevY = curY
            }
            // Process all events at curY.
            while (i < m && events[i].y == curY) {
                var lIdx = xs.binarySearch(events[i].x1)
                if (lIdx < 0) lIdx = -lIdx - 1
                var rIdx = xs.binarySearch(events[i].x2)
                if (rIdx < 0) rIdx = -rIdx - 1
                st.update(1, 0, xs.size - 1, lIdx, rIdx, events[i].type)
                i++
            }
        }

        val totalArea = cumArea
        val target = totalArea / 2.0

        // Now, the union–area function F(y) is piecewise linear.
        // Find the first segment where the cumulative area crosses target.
        for (seg in segs) {
            val segArea = seg.unionX * (seg.yEnd - seg.yStart)
            if (target <= seg.startCum + segArea + 1e-10) {
                val needed = target - seg.startCum
                // If unionX is 0, then the area does not increase; skip this segment.
                if (seg.unionX < 1e-10) continue
                val dy = needed / seg.unionX
                return seg.yStart + dy
            }
        }
        return prevY  // fallback (should not happen)
    }

    // Compress an array of doubles to a sorted array of unique values.
    private fun compress(arr: DoubleArray): DoubleArray {
        arr.sort()
        val cnt = arr.distinct().count()
        val res = DoubleArray(cnt)
        res[0] = arr[0]
        var j = 1
        for (i in 1 until arr.size) {
            if (arr[i] != arr[i - 1]) {
                res[j++] = arr[i]
            }
        }
        return res
    }

    // Event for sweep-line (vertical boundaries).
    data class Event(val y: Double, val x1: Double, val x2: Double, val type: Int)  // +1 for adding, -1 for removing an interval.

    // Segment representing a portion of the union–area function.
    data class SweepSegment(val yStart: Double, val yEnd: Double, val startCum: Double, val unionX: Double)

    class SegmentTree(xs: DoubleArray) {
        private val n: Int = xs.size
        private val tree: DoubleArray = DoubleArray(4 * n) // tree[idx]: total length covered in the node's interval.
        private val count: IntArray = IntArray(4 * n) // count[idx]: coverage count.
        private val xs: DoubleArray = xs // compressed x–coordinates.

        // Update the range [ql, qr) with delta.
        fun update(idx: Int, l: Int, r: Int, ql: Int, qr: Int, delta: Int) {
            if (qr <= l || ql >= r) return
            if (ql <= l && r <= qr) {
                count[idx] += delta
            } else {
                val mid = (l + r) shr 1
                update(idx * 2, l, mid, ql, qr, delta)
                update(idx * 2 + 1, mid, r, ql, qr, delta)
            }
            tree[idx] = when {
                count[idx] > 0 -> xs[r] - xs[l]
                r - l == 1 -> 0.0
                else -> tree[idx * 2] + tree[idx * 2 + 1]
            }
        }

        fun query(): Double {
            return tree[1]
        }
    }
}
