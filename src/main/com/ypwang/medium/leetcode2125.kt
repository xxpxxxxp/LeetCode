package com.ypwang.medium

class Solution2125 {
    fun numberOfBeams(bank: Array<String>): Int {
        var rst = 0
        var pre = 0

        for (s in bank) {
            val c = s.count { it == '1' }
            if (c > 0) {
                rst += pre * c
                pre = c
            }
        }

        return rst
    }
}