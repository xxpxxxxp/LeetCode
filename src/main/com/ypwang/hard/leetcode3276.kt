package com.ypwang.hard

class Solution3276 {
    fun maxScore(grid: List<List<Int>>): Int {
        val rows = grid.size
        val cols = grid[0].size

        val valueSet = grid.flatMap { it }.toSet()
        val valueList = valueSet.sortedDescending().toMutableList()

        val valToRows = mutableMapOf<Int, MutableSet<Int>>()
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                val v = grid[i][j]
                valToRows.getOrPut(v) { mutableSetOf<Int>() }.add(i)
            }
        }

        // Run DFS on rows with cell values in descending order
        fun dfs(rowSet: MutableSet<Int>, remainingValues: MutableList<Int>, score: Int): Int {
            if (remainingValues.isEmpty())
                return score

            val value = remainingValues.removeAt(0)
            val scoreList = mutableListOf<Int>()

            for (row in valToRows[value]!!)
                if (row !in rowSet) {
                    rowSet.add(row)
                    scoreList.add(dfs(rowSet, remainingValues, score + value))
                    rowSet.remove(row)
                }

            if (scoreList.isEmpty())
                scoreList.add(dfs(rowSet, remainingValues, score))

            remainingValues.add(0, value)
            return scoreList.maxOrNull()!!
        }

        return dfs(mutableSetOf(), valueList, 0)
    }
}

fun main() {
    println(Solution3276().maxScore(listOf(
        listOf(8,7,6),
        listOf(8,3,2)
    )))
}