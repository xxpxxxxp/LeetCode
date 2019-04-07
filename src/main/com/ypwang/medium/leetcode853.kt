package com.ypwang.medium

class Solution853 {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val t = position.zip(speed).sortedByDescending { it.first }.map { (target - it.first).toDouble() / it.second }

        var count = 0
        var cur = Double.MIN_VALUE

        for (car in t) {
            if (car > cur) {
                cur = car
                count++
            }
        }

        return count
    }
}

fun main() {
    println(Solution853().carFleet(12, intArrayOf(10,8,0,5,3), intArrayOf(2,4,1,1,3)))
}