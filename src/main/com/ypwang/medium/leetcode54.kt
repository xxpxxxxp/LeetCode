package com.ypwang.medium

class Solution54 {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        if (matrix.isEmpty()) return listOf()

        val n = matrix.size
        val m = matrix[0].size

        var x = 0
        var y = 0

        var round = 0
        var direction = 0

        val sb = mutableListOf<Int>()
        label@ while (true) {
            sb.add(matrix[y][x])

            when (direction) {
                0 -> {
                    x++
                    if (x >= m - round) {
                        x--
                        y++
                        direction = 1
                    }
                    if (y >= n - round)
                        break@label
                }
                1 -> {
                    y++
                    if (y >= n - round) {
                        y--
                        x--
                        direction = 2
                    }
                    if (x < round)
                        break@label
                }
                2 -> {
                    x--
                    if (x < round) {
                        x++
                        y--
                        direction = 3
                    }
                    if (y <= round)
                        break@label
                }
                3 -> {
                    y--
                    if (y < round + 1) {
                        y++
                        x++
                        direction = 0
                        round++
                    }
                    if (x >= m - round)
                        break@label
                }
            }
        }

        return sb
    }
}

fun main(args: Array<String>) {
    println(Solution54().spiralOrder(
            arrayOf(
                    intArrayOf(1,2,3,4),
                    intArrayOf(5,6,7,8),
                    intArrayOf(9,10,11,12),
                    intArrayOf(13,14,15,16)
            )
    ))
}