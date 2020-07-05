package com.ypwang.easy

class Solution1502 {
    fun canMakeArithmeticProgression(arr: IntArray): Boolean {
        arr.sort()
        val diff = arr[1] - arr[0]

        for (i in 1 until arr.lastIndex) {
            if (arr[i+1] - arr[i] != diff) return false
        }

        return true
    }
}