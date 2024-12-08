package com.ypwang.hard

class Solution3382 {
    fun maxRectangleArea(xCoord: IntArray, yCoord: IntArray): Long {
        val n = xCoord.size
        val co = Array(n) { IntArray(2) }
        val sy = imap(yCoord)

        // Step 1: Map coordinates to compressed y-values
        for (i in 0 until n)
            co[i] = intArrayOf(xCoord[i], sy.binarySearch(yCoord[i]))

        // Step 2: Sort the coordinates first by x, then by y
        co.sortWith(compareBy({ it[0] }, { it[1] }))

        // Step 3: Initialize Fenwick Tree and helper maps
        val map = mutableMapOf<Long, Int>()
        val mapx = mutableMapOf<Long, Int>()
        var ans = -1L
        val ft = IntArray(sy.size + 1)

        // Step 4: Iterate through the coordinates and find rectangles
        for (i in co.indices) {
            addFenwick(ft, co[i][1], 1)

            // Step 5: Check for possible rectangles
            if (i - 1 >= 0 && co[i][0] == co[i - 1][0]) {
                val yc = (co[i][1].toLong() shl 32) or co[i - 1][1].toLong()
                val aft = sumFenwick(ft, co[i][1]) - sumFenwick(ft, co[i - 1][1] - 1)

                // Step 6: Update the map and check if the rectangle is valid
                if (map.containsKey(yc)) {
                    val bef = map[yc]!!
                    if (aft == bef + 2) {
                        val x = mapx[yc]!!
                        val S = (co[i][0] - x).toLong() * (sy[co[i][1]] - sy[co[i - 1][1]])
                        ans = maxOf(ans, S)
                    }
                }

                map[yc] = aft
                mapx[yc] = co[i][0]
            }
        }

        // Step 7: Return the maximum area found
        return ans
    }

    // Fenwick Tree sum query
    private fun sumFenwick(ft: IntArray, i: Int): Int {
        var sum = 0
        var index = i + 1
        while (index > 0) {
            sum += ft[index]
            index -= index and -index
        }
        return sum
    }

    // Fenwick Tree update
    private fun addFenwick(ft: IntArray, i: Int, v: Int) {
        if (v == 0 || i < 0) {
            return
        }

        val n = ft.size
        var index = i + 1
        while (index < n) {
            ft[index] += v
            index += index and -index
        }
    }

    // Compress y-values
    private fun imap(a: IntArray): IntArray {
        val imap = a.copyOf()
        imap.sort()
        var p = 1
        for (i in 1 until imap.size) {
            if (imap[i] != imap[p - 1]) {
                imap[p++] = imap[i]
            }
        }
        return imap.copyOf(p)
    }
}
