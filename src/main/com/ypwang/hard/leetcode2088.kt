package com.ypwang.hard

class Solution2088 {
    fun countPyramids(grid: Array<IntArray>): Int {
        for (arr in grid) {
            var c = 0
            for ((i, v) in arr.withIndex()) {
                c += v
                arr[i] = c
            }
        }

        var rst = 0
        for ((i, arr) in grid.withIndex()) {
            for (j in arr.indices) {
                if (j != 0 && arr[j] - arr[j-1] > 0) {
                    // go up
                    for (h in 1..i) {
                        if (j - h >= 0 && j + h < arr.size && grid[i-h][j+h] - (if (j-h == 0) 0 else grid[i-h][j-h-1]) == 2 * h + 1)
                            rst++
                        else
                            break
                    }

                    // go down
                    for (h in 1 until (grid.size - i)) {
                        if (j - h >= 0 && j + h < arr.size && grid[i+h][j+h] - (if (j-h == 0) 0 else grid[i+h][j-h-1]) == 2 * h + 1)
                            rst++
                        else
                            break
                    }
                }
            }
        }

        return rst
    }
}

fun main() {
    println(Solution2088().countPyramids(
        arrayOf(intArrayOf(0,1,1,0), intArrayOf(1,1,1,1))
    ))
    println(Solution2088().countPyramids(
        arrayOf(intArrayOf(1,1,1), intArrayOf(1,1,1))
    ))
    println(Solution2088().countPyramids(
        arrayOf(intArrayOf(1,0,1), intArrayOf(0,0,0), intArrayOf(1,0,1))
    ))
    println(Solution2088().countPyramids(
        arrayOf(intArrayOf(1,1,1,1,0), intArrayOf(1,1,1,1,1), intArrayOf(1,1,1,1,1), intArrayOf(0,1,0,0,1))
    ))
}