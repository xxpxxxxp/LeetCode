package com.ypwang.hard

class Solution639 {
    fun numDecodings(s: String): Int {
        val dp = IntArray(s.length+1){1}

        for (i in 1..s.length) {
            var sum = 0L
            when (s[i-1]) {
                // impossible to combine with previous char
                '0' -> {
                    if (i == 1) return 0
                    when (s[i-2]) {
                        in '1'..'2' -> sum += dp[i-2]
                        '*' -> sum += 2L * dp[i-2]
                    }
                }
                in '7'..'9' -> {
                    sum += dp[i-1]
                    // check if we could combine with previous char
                    if (i > 1) {
                        when (s[i-2]) {
                            '1', '*' -> sum += dp[i-2]
                        }
                    }
                }
                in '1'..'6' -> {
                    sum += dp[i-1]
                    // check if we could combine with previous char
                    if (i > 1) {
                        sum += when (s[i-2]) {
                            in '1'..'2' -> dp[i-2].toLong()
                            '*' ->
                                // '*' can be treated as '1' or '2'
                                2L * dp[i-2]
                            else -> 0L
                        }
                    }
                }
                '*' -> {
                    sum += 9L * dp[i-1]
                    // check if we could combine with previous char
                    if (i > 1) {
                        sum += when (s[i-2]) {
                            '1' -> 9L * dp[i-2]
                            '2' -> 6L * dp[i-2]
                            '*' ->
                                // '**' can be see as '11'..'19', '21'..'26'
                                15L * dp[i-2]
                            else -> 0L
                        }
                    }
                }
            }
            dp[i] = (sum % 1000000007).toInt()
        }

        return dp.last()
    }
}

fun main() {
    println(Solution639().numDecodings("*********"))
    println(Solution639().numDecodings("1*72*"))
    println(Solution639().numDecodings("*1*1*0"))
    println(Solution639().numDecodings("*"))
    println(Solution639().numDecodings("1*"))
    println(Solution639().numDecodings("12**610"))
    println(Solution639().numDecodings("**********1111111111"))
}