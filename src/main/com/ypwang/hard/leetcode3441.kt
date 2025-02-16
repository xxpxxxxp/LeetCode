package com.ypwang.hard

class Solution3441 {
    private val dp = Array(50001) { Array(26) { Array(4) { Pair(-1, '~') } } }
    private val GOOD = Pair(0, '~')
    private val BAD = Pair(-1, '~')

    fun minCostGoodCaption(caption: String): String {
        val n = caption.length
        if (n < 3) return ""

        for (last in 0 until 26)
            for (cnt in 0..3)
                dp[n][last][cnt] = if (cnt >= 3) GOOD else BAD

        for (i in n - 1 downTo 0) {
            val captionChar = caption[i] - 'a'
            for (last in 0 until 26) {
                for (cnt in 0..3) {
                    var bestChar = '~'
                    var bestCost = -1
                    for (ch in 0 until 26) {
                        if (cnt in 1 until 3 && ch != last)
                            continue

                        val nextCnt = minOf(3, 1 + if (ch == last) cnt else 0)
                        val res = dp[i + 1][ch][nextCnt]
                        if (res.first == -1)
                            continue

                        val changeCost = Math.abs(captionChar - ch)
                        if (bestCost == -1 || changeCost + res.first < bestCost) {
                            bestCost = changeCost + res.first
                            bestChar = ch.toChar()
                        }
                    }
                    dp[i][last][cnt] = Pair(bestCost, bestChar)
                }
            }
        }

        val res = IntArray(n)
        var curr = dp[0][0][0]
        var cnt = 0
        for (i in 0 until n) {
            res[i] = curr.second.code
            if (i != n - 1) {
                val nextCnt = minOf(3, 1 + if (i > 0 && res[i] == res[i - 1]) cnt else 0)
                cnt = nextCnt
                curr = dp[i + 1][res[i]][nextCnt]
            }
        }
        return res.joinToString("") { ('a' + it).toString() }
    }
}

fun main() {
    println(Solution3441().minCostGoodCaption("cdcd"))
}