package com.ypwang.easy

class Solution2287 {
    fun rearrangeCharacters(s: String, target: String): Int {
        val arr = IntArray(26)
        for (c in s) {
            arr[c - 'a']++
        }

        val trr = IntArray(26)
        for (c in target) {
            trr[c - 'a']++
        }

        return trr.zip(arr).filter { it.first > 0 }.map { it.second / it.first }.minOrNull()!!
    }
}