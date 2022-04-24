package com.ypwang.medium

class Solution2250 {
    fun countRectangles(rectangles: Array<IntArray>, points: Array<IntArray>): IntArray {
        val ls = mutableListOf<Int>()
        rectangles.sortByDescending { it[0] }
        var i = 0
        val rst = IntArray(points.size)

        for ((idx, arr) in points.withIndex().sortedByDescending { it.value[0] }) {
            val (x, y) = arr
            while (i < rectangles.size && rectangles[i][0] >= x) {
                val j = rectangles[i++][1]
                ls.add(ls.binarySearch(j).let { if (it < 0) -it-1 else it }, j)
            }

            var l = 0
            var r = ls.size
            while (l < r) {
                val mid = (l + r) / 2
                if (ls[mid] >= y)
                    r = mid
                else
                    l = mid+1
            }

            rst[idx] = ls.size - l
        }

        return rst
    }
}

fun main() {
    println(Solution2250().countRectangles(
        arrayOf(intArrayOf(7,1),intArrayOf(2,6),intArrayOf(1,4),intArrayOf(5,2),intArrayOf(10,3),intArrayOf(2,4),intArrayOf(5,9)),
        arrayOf(intArrayOf(10,3),intArrayOf(8,10),intArrayOf(2,3),intArrayOf(5,4),intArrayOf(8,5),intArrayOf(7,10),intArrayOf(6,6),intArrayOf(3,6))
    ).toList())

    println(Solution2250().countRectangles(
        arrayOf(intArrayOf(1,1),intArrayOf(2,2),intArrayOf(3,3)),
        arrayOf(intArrayOf(1,3),intArrayOf(1,1))
    ).toList())

    println(Solution2250().countRectangles(
        arrayOf(intArrayOf(1,2),intArrayOf(2,3),intArrayOf(2,5)),
        arrayOf(intArrayOf(2,1),intArrayOf(1,4))
    ).toList())
}