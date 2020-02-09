package com.ypwang.easy

class Solution1346 {
    fun checkIfExist(arr: IntArray): Boolean {
        val cache = mutableSetOf<Int>()

        for (i in arr) {
            if (i shl 1 in cache) return true
            if (i and 0x1 == 0 && i shr 1 in cache) return true
            cache.add(i)
        }

        return false
    }
}