package com.ypwang.easy

class Solution1566 {
    fun containsPattern(arr: IntArray, m: Int, k: Int): Boolean {
        var count = 0
        for (i in 0 until arr.size - m) {
            if (arr[i] != arr[i+m])
                count = 0
            else
                count++

            if (count == (k-1) * m)
                return true
        }

        return false
    }
}