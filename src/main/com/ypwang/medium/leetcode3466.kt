package com.ypwang.medium

class Solution3466 {
    fun sortMatrix(grid: Array<IntArray>): Array<IntArray> {
        for (i in 0 until grid.size) {
            var ns = mutableListOf<Int>()
            var j = 0
            while (i + j < grid.size) {
                ns.add(grid[i+j][j])
                j++
            }
            ns.sortDescending()
            j = 0
            while (i + j < grid.size) {
                grid[i+j][j] = ns[j]
                j++
            }
        }

        for (i in 1 until grid.size) {
            var ns = mutableListOf<Int>()
            var j = 0
            while (i + j < grid.size) {
                ns.add(grid[j][i+j])
                j++
            }
            ns.sort()
            j = 0
            while (i + j < grid.size) {
                grid[j][i+j] = ns[j]
                j++
            }
        }

        return grid
    }
}

fun main() {
    println(Solution3466().sortMatrix(arrayOf(
        intArrayOf(1,7,3), intArrayOf(9,8,2), intArrayOf(4,5,6)
    )))
}