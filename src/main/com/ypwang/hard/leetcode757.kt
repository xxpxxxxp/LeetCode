package com.ypwang.hard

class Solution757 {
    fun intersectionSizeTwo(intervals: Array<IntArray>): Int {
    val selected = mutableListOf<Int>()
    for (interval in intervals.sortedWith(Comparator{ a, b -> if (a[1] != b[1]) a[1] - b[1] else b[0] - a[0] })) {
        val left = selected.binarySearch(interval[0]).let { if (it < 0) -it-1 else it }
        val right = selected.binarySearch(interval[1]).let { if (it < 0) -it-1 else it+1 }

        if (right - left == 0) {
            selected.add(interval[1]-1)
        }
        if (right - left < 2) {
            selected.add(interval[1])
        }
    }

    return selected.size
}
}

fun main() {
    println(Solution757().intersectionSizeTwo(arrayOf(
            intArrayOf(0,9), intArrayOf(0,2), intArrayOf(2,7), intArrayOf(8,10), intArrayOf(6,7), intArrayOf(3,7),
            intArrayOf(1,9), intArrayOf(0,9), intArrayOf(3,9), intArrayOf(3,9)
    )))
    println(Solution757().intersectionSizeTwo(arrayOf(
            intArrayOf(2,10), intArrayOf(3,7), intArrayOf(3,15), intArrayOf(4,11), intArrayOf(6,12), intArrayOf(6,16),
            intArrayOf(7,8), intArrayOf(7,11), intArrayOf(7,15), intArrayOf(11,12)
    )))
    println(Solution757().intersectionSizeTwo(arrayOf(
            intArrayOf(1,3), intArrayOf(1,4), intArrayOf(2,5), intArrayOf(3,5)
    )))
    println(Solution757().intersectionSizeTwo(arrayOf(
            intArrayOf(1,2), intArrayOf(2,3), intArrayOf(2,4), intArrayOf(4,5)
    )))
}