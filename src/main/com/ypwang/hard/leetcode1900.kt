package com.ypwang.hard

class Solution1900 {
    fun earliestAndLatest(n: Int, firstPlayer: Int, secondPlayer: Int): IntArray {
        val cache = Array(29) { Array(29) { arrayOfNulls<IntArray>(29) } }

        fun dp(l: Int, r: Int, total: Int): IntArray {
            if (l > r)
                return dp(r, l, total)

            if (l == r)
                return intArrayOf(1, 1)

            if (cache[l][r][total] == null) {
                val ans = intArrayOf(n, 0)
                val nextRound = (total + 1) / 2
                for (i in 1..l) {
                    val lWin = i-1
                    val lLose = l-i

                    for (j in lLose + 1 + maxOf(r - total/2 - 1, 0)..minOf(r - 1 - lWin, nextRound - i)) {
                        val t = dp(i, j, nextRound)
                        ans[0] = minOf(ans[0], t[0])
                        ans[1] = maxOf(ans[1], t[1])
                    }
                }
                cache[l][r][total] = ans.map { it+1 }.toIntArray()
            }

            return cache[l][r][total]!!
        }

        return dp(firstPlayer, n - secondPlayer + 1, n)
    }
}