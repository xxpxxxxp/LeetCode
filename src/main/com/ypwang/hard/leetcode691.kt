package com.ypwang.hard

class Solution691 {
    fun minStickers(stickers: Array<String>, target: String): Int {
        val stks = stickers.map {
            val a = IntArray(26)
            for (c in it) {
                a[c - 'a']++
            }
            a
        }

        val dp = IntArray(1 shl target.length){ -1 }
        dp[0] = 0

        for (state in 0 until (1 shl target.length)) {
            if (dp[state] == -1) continue

            for (sticker in stks) {
                var now = state
                val cp = sticker.copyOf()
                for (i in 0 until target.length) {
                    if (now and (1 shl i) == 0 && cp[target[i] - 'a'] > 0) {
                        cp[target[i] - 'a']--
                        now = now or (1 shl i)
                    }
                }

                if (dp[now] == -1 || dp[now] > dp[state] + 1) {
                    dp[now] = dp[state] + 1
                }
            }
        }

        return dp.last()
    }
}

fun main() {
    println(Solution691().minStickers(arrayOf("with", "example", "science"),"thehat"))
}