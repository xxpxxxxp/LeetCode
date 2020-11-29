package com.ypwang.medium

class Solution926 {
    fun minFlipsMonoIncr(S: String): Int {
        var rst = S.count { it == '0' }

        // p pre 1
        // r rest 0
        var (p, r) = Pair(0, rst)

        for (i in 0 until S.length) {
            when (S[i]) {
                '0' -> r--
                '1' -> p++
            }

            if ((p + r) < rst) {
                rst = p + r
            }
        }

        return rst
    }
}

fun main() {
    println(Solution926().minFlipsMonoIncr("010110"))
}