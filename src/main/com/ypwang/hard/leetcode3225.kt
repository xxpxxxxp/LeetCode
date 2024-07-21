package com.ypwang.hard

class Solution3225 {
    fun maximumScore(grid: Array<IntArray>): Long {
        val n = grid.size
        if (n == 1)
            return 0

        var prevColW = LongArray(n + 1)
        var prevColWo = LongArray(n + 1)

        for (j in 1 until n) {
            val curColW = LongArray(n + 1)
            val curColWo = LongArray(n + 1)

            for (i in 0..n) {
                var prevColVal = 0L
                var curColVal = 0L
                for (p in 0 until i)
                    curColVal += grid[p][j]

                for (k in 0..n) {
                    if (k in 1..i)
                        curColVal -= grid[k - 1][j]

                    if (k > i)
                        prevColVal += grid[k - 1][j - 1]

                    curColWo[k] = maxOf(curColWo[k], prevColVal + prevColWo[i], prevColW[i])
                    curColW[k] = maxOf(curColW[k], curColVal + prevColW[i], curColVal + prevColVal + prevColWo[i])
                }
            }

            prevColW = curColW
            prevColWo = curColWo
        }

        return prevColW.max()!!
    }
}
