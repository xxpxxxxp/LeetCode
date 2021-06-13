package com.ypwang.easy

class Solution1893 {
    fun isCovered(ranges: Array<IntArray>, left: Int, right: Int): Boolean {
        val len = IntArray(50)
        for ((s, e) in ranges) {
            len[s-1]++
            len[e]--
        }

        var count = 0
        for (i in 0 until 50) {
            count += len[i]
            if (i in (left-1) until right && count == 0) {
                return false
            }
        }

        return true
    }
}

fun main() {
    println(Solution1893().isCovered(arrayOf(
        intArrayOf(1,2), intArrayOf(3,4), intArrayOf(5,6)
    ), 2, 5))
}