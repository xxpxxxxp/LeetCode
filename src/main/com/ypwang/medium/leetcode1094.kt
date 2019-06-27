package com.ypwang.medium

class Solution1094 {
    fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
        trips.flatMap {listOf(it[1] to it[0], it[2] to -it[0]) }.groupBy { it.first }.mapValues { it.value.sumBy { p -> p.second } }.toList().sortedBy { it.first }.fold(0) {
            acc, cur ->
                if (cur.second > 0 && acc + cur.second > capacity) return false
                acc + cur.second
        }

        return true
    }
}

fun main() {
    println(Solution1094().carPooling(arrayOf(intArrayOf(2,1,5), intArrayOf(3,3,7)), 4))
    println(Solution1094().carPooling(arrayOf(intArrayOf(2,1,5), intArrayOf(3,3,7)), 5))
    println(Solution1094().carPooling(arrayOf(intArrayOf(2,1,5), intArrayOf(3,5,7)), 3))
    println(Solution1094().carPooling(arrayOf(intArrayOf(3,2,7), intArrayOf(3,7,9), intArrayOf(8,3,9)), 11))
}