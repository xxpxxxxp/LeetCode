package com.ypwang.medium

class Solution825 {
    fun numFriendRequests(ages: IntArray): Int {
        val group = ages.groupBy { it }.mapValues { it.value.size }.toList()

        var count = 0
        for ((age1, num1) in group) {
            for ((age2, num2) in group) {
                if (age2 <= 0.5 * age1 + 7 || age2 > age1 || (age2 > 100 && age1 < 100)) continue
                count += num1 * num2
                if (age1 == age2) count -= num1
            }
        }
        return count
    }
}

fun main() {
    println(Solution825().numFriendRequests(intArrayOf(73,106,39,6,26,15,30,100,71,35,46,112,6,60,110)))
}