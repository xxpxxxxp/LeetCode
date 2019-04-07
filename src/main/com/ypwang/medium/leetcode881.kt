package com.ypwang.medium

class Solution881 {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()

        var count = 0
        var i = 0
        var j = people.lastIndex

        while (i < j) {
            if (people[i] + people[j] <= limit) {
                i++
                j--
            } else {
                j--
            }
            count++
        }

        if (i == j)
            count++

        return count
    }
}

fun main() {
    println(Solution881().numRescueBoats(intArrayOf(3,5,3,4), 5))
}