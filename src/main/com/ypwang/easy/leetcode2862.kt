package com.ypwang.easy

class Solution2862 {
    fun circularGameLosers(n: Int, k: Int): IntArray {
        val arr = BooleanArray(n)
        var idx = 0
        arr[0] = true
        for (i in 1 .. n) {
            idx = (idx + i * k) % n
            if (arr[idx])
                return arr.withIndex().filter { !it.value }.map { it.index + 1 }.toIntArray()
            arr[idx] = true
        }
        return intArrayOf()
    }
}