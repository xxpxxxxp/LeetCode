package com.ypwang.medium

class Solution2002 {
    fun maxProduct(s: String): Int {
        val dp = IntArray(1 shl s.length){1}
        dp[0] = 0

        for (i in 1 until dp.size) {
            var start = 0
            var end = s.lastIndex

            while (start < end) {
                if (i and (1 shl start) == 0)
                    start++
                else if (i and (1 shl end) == 0)
                    end--
                else {
                    dp[i] =
                        if (s[start] != s[end]) 0
                        else if (start == end) 1
                        else 2 + dp[i xor (1 shl start) xor (1 shl end)]
                    break
                }
            }
        }

        var rst = 0
        for  (i in dp.lastIndex downTo 0) {
            val mask = ((1 shl s.length) - 1) xor i
            var j = mask
            while (j != 0) {
                rst = maxOf(rst, dp[i] * dp[j])
                j = (j-1) and mask
            }
        }

        return rst
    }
}

fun main() {
    println(Solution2002().maxProduct("leetcodecom"))
    println(Solution2002().maxProduct("bb"))
    println(Solution2002().maxProduct("accbcaxxcxx"))
}