package com.ypwang.medium

class Solution826 {
    fun maxProfitAssignment(difficulty: IntArray, profit: IntArray, worker: IntArray): Int {
        val p = difficulty.zip(profit).sortedBy { it.first }
        val mostp = mutableListOf<Pair<Int, Int>>()

        var max = 0
        for (l in p) {
            if (l.second > max)
                max = l.second

            if (mostp.isNotEmpty() && l.first == mostp.last().first) {
                mostp.removeAt(mostp.lastIndex)
            }
            mostp.add(l.first to max)
        }

        return worker.map { w ->
            val i = mostp.binarySearch { it.first - w }.let { if (it >= 0) it else -it - 1 - 1 }
            if (i >= 0) mostp[i].second
            else 0
        }.sum()
    }
}

fun main() {
    println(Solution826().maxProfitAssignment(intArrayOf(23,30,35,35,43,46,47,81,83,98), intArrayOf(8,11,11,20,33,37,60,72,87,95), intArrayOf(95,46,47,97,11,35,99,56,41,92)))
}