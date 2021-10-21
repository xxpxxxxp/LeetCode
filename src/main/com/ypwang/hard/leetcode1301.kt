package com.ypwang.hard

class Solution1301 {
    fun pathsWithMaxScore(board: List<String>): IntArray {
        val m = board.size
        val n = board.first().length

        val dp = Array(m) { Array<IntArray?>(n) { null } }
        dp[m-1][n-1] = intArrayOf(0, 1)

        for (i in m - 1 downTo 0) {
            for (j in n - 1 downTo 0) {
                when (board[i][j]) {
                    'X' -> dp[i][j] = intArrayOf(0, 0)
                    else -> {
                        val pre = mutableListOf<IntArray>()

                        if (i + 1 < m) pre.add(dp[i + 1][j]!!)
                        if (j + 1 < n) pre.add(dp[i][j + 1]!!)
                        if (i + 1 < m && j + 1 < n) pre.add(dp[i + 1][j + 1]!!)

                        if (pre.isNotEmpty()) {
                            var collect = pre.map { it[0] }.maxOrNull()!!
                            val step = pre.filter { it[0] == collect }.fold(0) { sum, it ->
                                (sum + it[1]) % 1000000007
                            }

                            if (step == 0)
                                dp[i][j] = intArrayOf(0, 0)
                            else {
                                if (board[i][j].isDigit())
                                    collect += board[i][j] - '0'

                                dp[i][j] = intArrayOf(collect, step)
                            }
                        }
                    }
                }
            }
        }

        return dp[0][0]!!
    }
}

fun main() {
    println(Solution1301().pathsWithMaxScore(listOf("E23", "2X2", "12S")).toList())
    println(Solution1301().pathsWithMaxScore(listOf("E12", "1X1", "21S")).toList())
    println(Solution1301().pathsWithMaxScore(listOf("E11", "XXX", "11S")).toList())
}