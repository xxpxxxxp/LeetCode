package com.ypwang.medium

class Solution1535 {
    fun getWinner(arr: IntArray, k: Int): Int {
        var c = 0
        var m = arr[0]

        for (i in 1 until arr.size) {
            if (arr[i] > m) {
                m = arr[i]
                c = 1
            } else
                c++

            if (c == k)
                return m
        }

        return m
    }
}

fun main() {
    println(Solution1535().getWinner(intArrayOf(2,1,3,5,4,6,7), 2))
}