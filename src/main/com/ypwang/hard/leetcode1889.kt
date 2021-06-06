package com.ypwang.hard

class Solution1889 {
    fun minWastedSpace(packages: IntArray, boxes: Array<IntArray>): Int {
        packages.sort()
        val sum = packages.fold(0L) { acc, i -> acc + i }

        fun helper(bs: IntArray): Long {
            bs.sort()
            if (bs.last() < packages.last())
                return Long.MAX_VALUE

            var rst = 0L
            var cur = 0
            for (box in bs) {
                if (cur > packages.lastIndex)
                    break

                val idx = 1 + packages.binarySearch(box, cur).let {
                    if (it < 0) -it-2 else it
                }

                if (idx > cur) {
                    rst += box.toLong() * (idx - cur)
                    cur = idx
                }
            }

            return rst - sum
        }

        return boxes.fold(Long.MAX_VALUE) { acc, arr ->
            minOf(acc, helper(arr))
        }.let { if (it == Long.MAX_VALUE) -1 else (it % 1000000007).toInt() }
    }
}

fun main() {
    println(Solution1889().minWastedSpace(intArrayOf(2,3,5), arrayOf(
        intArrayOf(4,8), intArrayOf(2,8)
    )))
    println(Solution1889().minWastedSpace(intArrayOf(2,3,5), arrayOf(
        intArrayOf(1,4), intArrayOf(2,3), intArrayOf(3,4)
    )))
    println(Solution1889().minWastedSpace(intArrayOf(3,5,8,10,11,12), arrayOf(
        intArrayOf(12), intArrayOf(11,9), intArrayOf(10,5,14)
    )))
}