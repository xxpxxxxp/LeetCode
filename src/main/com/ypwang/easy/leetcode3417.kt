package com.ypwang.easy

class Solution3417 {
    fun zigzagTraversal(grid: Array<IntArray>): List<Int> {
        var isLeft = false
        var count = true

        var x = 0
        var y = 0
        var rst = mutableListOf<Int>()

        while (true) {
            if (count)
                rst.add(grid[y][x])

            if (isLeft) {
                if (x-1 >= 0)
                    x--
                else if (++y < grid.size)
                    isLeft = !isLeft
                else
                    break
            } else {
                if (x+1 < grid[0].size)
                    x++
                else if (++y < grid.size)
                    isLeft = !isLeft
                else
                    break
            }

            count = !count
        }

        return rst
    }
}

fun main() {
    println(Solution3417().zigzagTraversal(arrayOf(intArrayOf(2,1), intArrayOf(2,1), intArrayOf(2,1))))
}