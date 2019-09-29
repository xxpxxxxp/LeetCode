package com.ypwang.easy

class Solution {
    fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
        arr.sort()

        var diff = Int.MAX_VALUE
        val rst = mutableListOf<List<Int>>()

        for (i in 1 until arr.size) {
            val d = arr[i] - arr[i-1]
            if (d == diff) rst.add(listOf(arr[i-1], arr[i]))
            else if (d < diff) {
                diff = d
                rst.clear()
                rst.add(listOf(arr[i-1], arr[i]))
            }
        }

        return rst
    }
}