package com.ypwang.medium

class Solution3228 {
    fun maxOperations(s: String): Int {
        var c = 0
        var rst = 0
        var b = true
        for (i in s) {
            when (i - '0') {
                0 ->
                    if (b) {
                        rst += c
                        b = false
                    }
                1 -> {
                    c++
                    b = true
                }
            }
        }

        return rst
    }
}
