package com.ypwang.hard

class Solution1416 {
    fun numberOfArrays(s: String, k: Int): Int {
        val dp = IntArray(s.length + 1)
        dp[dp.lastIndex] = 1

        val maxSize = k.toString().length
        for (i in s.lastIndex downTo 0) {
            var mul = 1L
            var value = 0L
            for (j in i downTo maxOf(0, i - maxSize)) {
                if (s[j] != '0') {
                    value += (s[j] - '0') * mul
                    if (value > k) break
                    dp[j] = (dp[j] + dp[i+1]) % 1000000007
                }
                mul *= 10
            }
        }
        return dp[0]
    }
}

fun main() {
    println(Solution1416().numberOfArrays("407780786171321121429620765476840275495357129574174233567552131453038760763182952432348422252546559691171161181440370120987634895458140447952079749439961325982629462531738374032416182281868731817661954890417245087359968833257550123324827240537957646002494771036413572415",823924906))
    println(Solution1416().numberOfArrays("1111111111111", 1000000000))
    println(Solution1416().numberOfArrays("1000", 10000))
    println(Solution1416().numberOfArrays("1000", 10))
    println(Solution1416().numberOfArrays("1317", 2000))
    println(Solution1416().numberOfArrays("2020", 30))
    println(Solution1416().numberOfArrays("1234567890", 90))
}