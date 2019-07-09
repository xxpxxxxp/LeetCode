package com.ypwang.medium

class Solution1109 {
    fun corpFlightBookings(bookings: Array<IntArray>, n: Int): IntArray {
        val inc = IntArray(n)

        for (book in bookings) {
            inc[book[0]-1] += book[2]
            if (book[1] < n) inc[book[1]] -= book[2]
        }

        val rst = IntArray(n)

        var count = 0
        for (i in 0 until inc.size) {
            count += inc[i]
            rst[i] = count
        }

        return rst
    }
}

fun main() {
    println(Solution1109().corpFlightBookings(arrayOf(intArrayOf(1,2,10), intArrayOf(2,3,20), intArrayOf(2,5,25)), 5).toList())
}