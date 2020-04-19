package com.ypwang.medium

class Solution1395 {
    fun numTeams(rating: IntArray): Int {
        val larger = IntArray(rating.size)
        val smaller = IntArray(rating.size)

        var rst = 0
        for ((i, v) in rating.withIndex()) {
            for (j in 0 until i) {
                if (rating[j] < v) {
                    smaller[i]++
                    rst += smaller[j]
                } else if (rating[j] > v) {
                    larger[i]++
                    rst += larger[j]
                }
            }
        }

        return rst
    }
}

fun main() {
    println(Solution1395().numTeams(intArrayOf(2,5,3,4,1)))
    println(Solution1395().numTeams(intArrayOf(2,1,3)))
    println(Solution1395().numTeams(intArrayOf(1,2,3,4)))
}