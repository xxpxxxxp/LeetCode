package com.ypwang.hard

class BookMyShow(n: Int, m: Int) {
    /**
     * Segment tree class to store sum of a range and maximum available seats in a row
     */
    class SegTree(var n: Int, var m: Int) {
        var sum: LongArray = LongArray(4 * n) // store sum of seats in a range
        var segTree: LongArray = LongArray(4 * n) // store maximum seats in a range

        init {
            build(0, 0, n - 1, m.toLong())
        }

        private fun build(index: Int, lo: Int, hi: Int, `val`: Long) {
            if (lo == hi) {
                segTree[index] = `val` // initialize segement tree with initial seat capacity
                sum[index] = `val` // initialize "sum" with initial seat capacity of a row
                return
            }
            val mid = (lo + hi) / 2
            build(2 * index + 1, lo, mid, `val`) // build left sub tree
            build(2 * index + 2, mid + 1, hi, `val`) // build right sub tree
            segTree[index] = maxOf(segTree[2 * index + 1], segTree[2 * index + 2]) // maximum seats in a row for subtrees
            sum[index] = sum[2 * index + 1] + sum[2 * index + 2] // sum of seats in a range
        }

        private fun update(index: Int, lo: Int, hi: Int, pos: Int, `val`: Int) {
            /**
             * Method to update segment tree based on the available seats in a row
             */
            if (lo == hi) {
                segTree[index] = `val`.toLong()
                sum[index] = `val`.toLong()
                return
            }
            val mid = (lo + hi) / 2
            if (pos <= mid) {  // position to update is in left
                update(2 * index + 1, lo, mid, pos, `val`)
            } else { // position to update is in right
                update(2 * index + 2, mid + 1, hi, pos, `val`)
            }
            // update segment tree and "sum" based on the update in "pos" index
            segTree[index] = maxOf(segTree[2 * index + 1], segTree[2 * index + 2])
            sum[index] = sum[2 * index + 1] + sum[2 * index + 2]
        }

        fun update(pos: Int, `val`: Int) {
            update(0, 0, n - 1, pos, `val`)
        }

        fun gatherQuery(k: Int, maxRow: Int): Int {
            return gatherQuery(0, 0, n - 1, k, maxRow)
        }

        private fun gatherQuery(index: Int, lo: Int, hi: Int, k: Int, maxRow: Int): Int {
            /**
             * Method to check if seats are available in a single row
             */
            if (segTree[index] < k || lo > maxRow) return -1
            if (lo == hi) return lo
            val mid = (lo + hi) / 2
            var c = gatherQuery(2 * index + 1, lo, mid, k, maxRow)
            if (c == -1) {
                c = gatherQuery(2 * index + 2, mid + 1, hi, k, maxRow)
            }
            return c
        }

        fun sumQuery(k: Int, maxRow: Int): Long {
            return sumQuery(0, 0, n - 1, k, maxRow)
        }

        private fun sumQuery(index: Int, lo: Int, hi: Int, l: Int, r: Int): Long {
            if (lo > r || hi < l) return 0 // not in range
            if (lo >= l && hi <= r) return sum[index] // in range
            val mid = (lo + hi) / 2
            return sumQuery(2 * index + 1, lo, mid, l, r) + sumQuery(2 * index + 2, mid + 1, hi, l, r)
        }
    }

    var segTree = SegTree(n, m)
    var rowSeats = IntArray(n) { m } // stores avaiable seats in a row, helps to find the vacant seat in a row

    fun gather(k: Int, maxRow: Int): IntArray {
        val row = segTree.gatherQuery(k, maxRow) // find row which has k seats
        if (row == -1) return intArrayOf() // can't find a row with k seats
        val col = segTree.m - rowSeats[row] // find column in the row which has k seats
        rowSeats[row] -= k // reduce the seats
        segTree.update(row, rowSeats[row]) // update the segment tree
        return intArrayOf(row, col)
    }

    fun scatter(k: Int, maxRow: Int): Boolean {
        var k = k
        val sum = segTree.sumQuery(0, maxRow) // find the sum for the given range [0, maxRow]
        if (sum < k) return false // can't find k seats in [0, maxRow]
        var i = 0
        while (i <= maxRow && k != 0) {
            if (rowSeats[i] > 0) {                       // if current row has seats then allocate those seats
                val t = minOf(rowSeats[i], k).toLong()
                rowSeats[i] -= t.toInt()
                k -= t.toInt()
                segTree.update(i, rowSeats[i]) // update the segment tree
            }
            i++
        }
        return true
    }
}