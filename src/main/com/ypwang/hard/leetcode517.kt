package com.ypwang.hard

class Solution517 {
    fun findMinMoves(machines: IntArray): Int {
        val sum = machines.sum()
        if (sum % machines.size != 0) return -1
        val average = sum / machines.size

        return machines.fold(0 to 0) { (max, cum), c ->
            maxOf(max, Math.abs(cum + c - average), c - average) to cum + c - average
        }.first
    }
}

fun main() {
//    println(Solution517().findMinMoves(intArrayOf(1,0,5)))
//    println(Solution517().findMinMoves(intArrayOf(0,3,0)))
    println(Solution517().findMinMoves(intArrayOf(2,5,2)))
    println(Solution517().findMinMoves(intArrayOf(9,1,8,8,9)))
}