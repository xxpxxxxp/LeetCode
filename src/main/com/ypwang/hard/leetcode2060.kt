package com.ypwang.hard

class Solution2060 {
    private val dp = Array(41) { Array(41) { BooleanArray(2000) } }

    fun possiblyEquals(s1: String, s2: String, i: Int = 0, j: Int = 0, diff: Int = 0): Boolean {
        fun processDigits(sign: Int): Boolean {
            var v = 0
            val sr = arrayOf(s1, s2)
            val arr = intArrayOf(i, j)
            val idx = maxOf(sign, 0)
            while (arr[idx] < sr[idx].length && sr[idx][arr[idx]].isDigit()) {
                v = v * 10 + (sr[idx][arr[idx]] - '0')

                arr[idx]++
                if (possiblyEquals(s1, s2, arr[0], arr[1], diff + v * sign))
                    return true
            }

            return false
        }

        if (i == s1.length && j == s2.length)
            return diff == 0

        if (!dp[i][j][1000+diff]) {
            dp[i][j][1000+diff] = true

            if (i < s1.length && s1[i].isDigit())
                return processDigits(-1)
            if (j < s2.length && s2[j].isDigit())
                return processDigits(1)
            if (diff > 0)
                return i < s1.length && possiblyEquals(s1, s2, i+1, j, diff-1)
            if (diff < 0)
                return j < s2.length && possiblyEquals(s1, s2, i, j+1, diff+1)

            return i < s1.length && j < s2.length && s1[i] == s2[j] && possiblyEquals(s1, s2, i+1, j+1, diff)
        }

        return false
    }
}

fun main() {
    println(Solution2060().possiblyEquals("internationalization", "i18n"))
}