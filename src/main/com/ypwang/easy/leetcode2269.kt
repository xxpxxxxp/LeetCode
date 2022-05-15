package com.ypwang.easy

class Solution2269 {
    fun divisorSubstrings(num: Int, k: Int): Int {
        val n = num.toString()
        var cnt = 0
        for (i in 0 .. (n.length-k)) {
            val sub = n.substring(i, i+k).toInt()
            if (sub != 0 && num % sub == 0)
                cnt++
        }

        return cnt
    }
}