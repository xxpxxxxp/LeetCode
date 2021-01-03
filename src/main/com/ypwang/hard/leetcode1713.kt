package com.ypwang.hard

import java.util.*

class Solution1713 {
    fun minOperations(target: IntArray, arr: IntArray): Int {
        val map = target.withIndex().map { it.value to it.index }.toMap()

        val lis = IntArray(arr.size)
        var len = 0
        for (v in arr) {
            if (v in map) {
                var i = Arrays.binarySearch(lis, 0, len, map[v]!!)
                if (i < 0) {
                    i = -(i + 1)
                }
                lis[i] = map[v]!!
                if (i == len) {
                    len++
                }
            }
        }

        return target.size - len
    }
}

fun main() {
    println(Solution1713().minOperations(intArrayOf(17,18,14,13,6,9,1,3,2,20), intArrayOf(18,15,14,6,6,13,15,20,2,6)))
    println(Solution1713().minOperations(intArrayOf(5,1,3), intArrayOf(9,4,2,3,4)))
    println(Solution1713().minOperations(intArrayOf(6,4,8,1,3,2), intArrayOf(4,7,6,2,3,8,6,1)))
}