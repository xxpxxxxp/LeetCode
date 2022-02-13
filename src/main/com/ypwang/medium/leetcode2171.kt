package com.ypwang.medium

class Solution2171 {
    fun minimumRemoval(beans: IntArray): Long {
        val arr = beans.groupBy { it }.mapValues { it.value.size }.toList().sortedBy { it.first }.toTypedArray()
        var sum = beans.fold(0L){ a, b -> a + b } - arr[0].first.toLong() * beans.size
        var min = sum
        var size = (beans.size - arr[0].second).toLong()

        for (i in 1 until arr.size) {
            sum -= size * (arr[i].first - arr[i-1].first)
            sum += arr[i-1].second.toLong() * arr[i-1].first

            min = minOf(min, sum)
            size -= arr[i].second
        }

        return min
    }
}

fun main() {
    println(Solution2171().minimumRemoval(intArrayOf(4,1,6,5)))
    println(Solution2171().minimumRemoval(intArrayOf(2,10,3,2)))
}