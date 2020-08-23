package com.ypwang.medium

class Solution1562 {
    fun findLatestStep(arr: IntArray, m: Int): Int {
        var rst = -1
        val length = IntArray(arr.size+2)
        val count = IntArray(arr.size+1)

        for ((i, c) in arr.withIndex()) {
            val left = length[c-1]
            val right = length[c+1]
            length[c-left] = left + right + 1
            length[c+right] = left + right + 1
            count[left]--
            count[right]--
            count[left+right+1]++
            if (count[m] > 0)
                rst = i+1
        }

        return rst
    }
}