package com.ypwang.medium

class Solution1871 {
    fun canReach(s: String, minJump: Int, maxJump: Int): Boolean {
        val dp = BooleanArray(s.length)
        dp[0] = true

        var count = 0
        for (i in 1 until s.length) {
            if (i >= minJump && dp[i - minJump])
                count++

            if (i > maxJump && dp[i - maxJump - 1])
                count--

            dp[i] = count > 0 && s[i] == '0'
        }

        return dp.last()
    }
}