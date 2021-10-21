package com.ypwang.hard

class Solution1187 {
    fun makeArrayIncreasing(arr1: IntArray, arr2: IntArray): Int {
        val replace = arr2.distinct().sorted().toTypedArray()
        var bfs = mutableMapOf(0 to arr1[0])
        if (replace[0] < arr1[0]) bfs[1] = replace[0]

        for (i in 1 until arr1.size) {
            if (bfs.isEmpty()) break
            val next = mutableMapOf<Int, Int>()

            for (pre in bfs) {
                if (pre.value < arr1[i]) {
                    next[pre.key] = minOf(arr1[i], next.getOrDefault(pre.key, Int.MAX_VALUE))
                }

                // try to replace current
                val idx = replace.binarySearch(pre.value).let { if (it < 0) -it-1 else it+1 }
                if (idx < replace.size) {
                    next[pre.key+1] = minOf(replace[idx], next.getOrDefault(pre.key+1, Int.MAX_VALUE))
                }
            }

            bfs = next
        }

        return bfs.keys.minOrNull() ?: -1
    }
}

fun main() {
    println(Solution1187().makeArrayIncreasing(intArrayOf(5,16,19,2,1,12,7,14,5,16), intArrayOf(6,17,4,3,6,13,4,3,18,17,16,7,14,1,16)))
    println(Solution1187().makeArrayIncreasing(intArrayOf(1,5,3,6,7), intArrayOf(1,3,2,4)))
    println(Solution1187().makeArrayIncreasing(intArrayOf(1,5,3,6,7), intArrayOf(4,3,1)))
    println(Solution1187().makeArrayIncreasing(intArrayOf(1,5,3,6,7), intArrayOf(1,6,3,3)))
}