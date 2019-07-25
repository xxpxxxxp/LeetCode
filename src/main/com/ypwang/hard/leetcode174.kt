package com.ypwang.hard

class Solution174 {
    fun calculateMinimumHP(dungeon: Array<IntArray>): Int {
        if (dungeon.isEmpty()) return 0

        val m = dungeon.size
        val n = dungeon[0].size

        for (i in m-1 downTo 0) {
            for (j in n-1 downTo 0) {
                var next = 0
                if (i+1 != m || j+1 != n) {
                    next = Int.MAX_VALUE
                    if (i+1 != m && dungeon[i+1][j] < next) next = dungeon[i+1][j]
                    if (j+1 != n && dungeon[i][j+1] < next) next = dungeon[i][j+1]
                }

                dungeon[i][j] = (next - dungeon[i][j]).let { if (it < 0) 0 else it }
            }
        }

        return dungeon[0][0] + 1
    }
}

fun main() {
    println(Solution174().calculateMinimumHP(arrayOf(intArrayOf(-2,-3,3), intArrayOf(-5,-10,1), intArrayOf(10,30,-5))))
}