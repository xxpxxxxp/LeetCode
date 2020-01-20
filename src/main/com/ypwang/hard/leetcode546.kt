package com.ypwang.hard

class Solution546 {
    fun removeBoxes(boxes: IntArray): Int {
        val memo = Array(boxes.size) { Array(boxes.size) { IntArray(boxes.size) } }

        fun dfs(ll: Int, rr: Int, kk: Int): Int {
            if (ll > rr) return 0

            if (memo[ll][rr][kk] == 0) {
                var l = ll
                var r = rr
                var k = kk
                while (l < r && boxes[r] == boxes[r-1]) {
                    r--
                    k++
                }
                memo[ll][rr][kk] = dfs(l, r-1, 0) + (k+1)*(k+1)
                for (i in l until r) {
                    if (boxes[i] == boxes[r])
                        memo[ll][rr][kk] = maxOf(memo[ll][rr][kk], dfs(l, i, k+1) + dfs(i+1, r-1, 0))
                }
            }

            return memo[ll][rr][kk]
        }

        return dfs(0, boxes.lastIndex, 0)
    }
}