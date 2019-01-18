package com.ypwang.easy

class Solution942 {
    fun diStringMatch(S: String): IntArray {
        var start = 0
        var end = S.length

        return (S.map {
            when (it) {
                'I' -> start++
                'D' -> end--
                else -> 0
            }
        }.toList() + start).toIntArray()
    }
}