package com.ypwang.easy

class Solution830 {
    fun largeGroupPositions(S: String): List<List<Int>> {
        val rst = mutableListOf<List<Int>>()
        var cur = '0'
        var start = 0
        for ((i, c) in S.withIndex()) {
            if (c != cur) {
                if (i - start >= 3) {
                    rst.add(listOf(start, i-1))
                }
                cur = c
                start = i
            }
        }
        if (S.length - start >= 3) {
            rst.add(listOf(start, S.lastIndex))
        }
        return rst
    }
}