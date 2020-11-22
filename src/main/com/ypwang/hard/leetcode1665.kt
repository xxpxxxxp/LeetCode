package com.ypwang.hard

class Solution1665 {
    fun minimumEffort(tasks: Array<IntArray>): Int =
        tasks.sortedBy { it[0] - it[1] }.fold(0 to 0) { (total, capital), (cost, min) ->
            if (min > capital)
                // need investment to meet requirement
                total + min - capital to min - cost
            else
                // no need to invest, capital reduced
                total to capital - cost
        }.first
}

fun main() {
    println(Solution1665().minimumEffort(arrayOf(intArrayOf(1,2), intArrayOf(2,4), intArrayOf(4,8))))
}