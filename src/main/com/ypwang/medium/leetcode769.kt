package com.ypwang.medium

class Solution769 {
    fun maxChunksToSorted(arr: IntArray): Int {
        var count = 0
        var index = 0
        while (index < arr.size) {
            var last = arr[index]
            index++
            while (index <= last) {
                if (arr[index] > last) {
                    last = arr[index]
                }
                index++
            }

            count++
        }
        return count
    }
}

fun main() {
    println(Solution769().maxChunksToSorted(intArrayOf(1,0,2,3,4)))
}