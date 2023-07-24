package com.ypwang.hard

class Solution2790 {
    fun maxIncreasingGroups(usageLimits: List<Int>): Int {
        val usageLimits = usageLimits.sorted()
        var total = 0L
        var k = 0L
        for (i in usageLimits.indices) {
            total += usageLimits[i]
            if (total >= (k + 1) * (k + 2) / 2)
                k++
        }
        return k.toInt()
    }
}

fun main() {
    println(Solution2790().maxIncreasingGroups(listOf(1,7,7,1)))
}