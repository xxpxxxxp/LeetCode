package com.ypwang.hard

class Solution768 {
    fun maxChunksToSorted(arr: IntArray): Int {
        val sorted = arr.sorted().toTypedArray()

        val hashPre = mutableMapOf<Int, Int>()
        val hashAfter = mutableMapOf<Int, Int>()

        var count = 0
        for (i in 0 until arr.size) {
            hashPre[arr[i]] = hashPre.getOrDefault(arr[i], 0) + 1
            hashAfter[sorted[i]] = hashAfter.getOrDefault(sorted[i], 0) + 1

            if (hashPre == hashAfter) {
                count++
                hashPre.clear()
                hashAfter.clear()
            }
        }

        return count
    }
}

fun main() {
    println(Solution768().maxChunksToSorted(intArrayOf(2,1,3,4,4)))
}