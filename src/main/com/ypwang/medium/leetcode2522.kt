package com.ypwang.medium

class Solution2522 {
    fun minimumPartition(s: String, k: Int): Int {
        var n = 0L
        var cnt = 1
        for (c in s) {
            if (n * 10 + (c - '0') > k) {
                cnt++
                n = 0L
            }
            n = n * 10 + (c - '0')
            if (n > k)
                return -1
        }
        return cnt
    }
}