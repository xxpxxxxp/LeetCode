package com.ypwang.easy

class Solution874 {
    fun helper(blockers: List<Int>, cur: Int, go: Int, goPositive: Boolean): Int {
        val b = blockers.binarySearch(cur)
        if (b >= 0) {  // standing on obstacle
            return if (goPositive) cur + go else cur - go
        } else {
            val index = -(b + 1)
            return if (goPositive) {
                if (index == blockers.size || blockers[index] > (cur + go))
                    cur + go
                else
                    blockers[index] - 1
            } else {
                if (index == 0 || blockers[index-1] < (cur - go))
                    cur - go
                else
                    blockers[index-1] + 1
            }
        }
    }

    fun robotSim(commands: IntArray, obstacles: Array<IntArray>): Int {
        val xo = obstacles.groupBy { it[0] }.mapValues { v -> v.value.map { it[1] }.sorted() }
        val yo = obstacles.groupBy { it[1] }.mapValues { v -> v.value.map { it[0] }.sorted() }

        var x = 0
        var y = 0
        var max = 0
        /* direction:
           0 -> go y+
           1 -> go x+
           2 -> go y-
           3 -> go x-
         */
        var direction = 0
        for (c in commands) {
            when (c) {
                -1 -> direction = (direction + 1) % 4
                -2 -> direction = (direction + 3) % 4
                else -> {
                    when (direction) {
                        0 -> {  // go y+
                            if (x !in xo) {
                                y += c
                            } else {
                                y = helper(xo[x]!!, y, c, true)
                            }
                        }
                        1 -> {  // go x+
                            if (y !in yo) {
                                x += c
                            } else {
                                x = helper(yo[y]!!, x, c, true)
                            }
                        }
                        2 -> {  // go y-
                            if (x !in xo) {
                                y -= c
                            } else {
                                y = helper(xo[x]!!, y, c, false)
                            }
                        }
                        3 -> {  // go x-
                            if (y !in yo) {
                                x -= c
                            } else {
                                x = helper(yo[y]!!, x, c, false)
                            }
                        }
                    }
                    val m = x * x + y * y
                    if (m > max) {
                        max = m
                    }
                }
            }
        }
        return max
    }
}

fun main(args: Array<String>) {
    println(Solution874().robotSim(intArrayOf(-2,-1,-2,3,7), arrayOf(
            intArrayOf(1,-3),intArrayOf(2,-3),intArrayOf(4,0),intArrayOf(-2,5),intArrayOf(-5,2),intArrayOf(0,0),intArrayOf(4,-4),intArrayOf(-2,-5),intArrayOf(-1,-2),intArrayOf(0,2)
    )))
}