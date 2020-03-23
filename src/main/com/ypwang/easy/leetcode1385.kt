package com.ypwang.easy

class Solution1385 {
    fun findTheDistanceValue(arr1: IntArray, arr2: IntArray, d: Int): Int {
        arr2.sort()
        return arr1.count {
            val idx = arr2.binarySearch(it)
            if (idx >= 0) false
            else {
                val i = -idx-1
                var m = Int.MAX_VALUE
                if (i < arr2.size)
                    m = Math.abs(it - arr2[i])
                if (i > 0)
                    m = minOf(m, Math.abs(it - arr2[i - 1]))
                m > d
            }
        }
    }
}