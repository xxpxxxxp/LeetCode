package com.ypwang.medium

class Solution120 {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        if (triangle.isEmpty())
            return 0

        val iter = triangle.iterator()
        var level = iter.next().toIntArray()

        while (iter.hasNext()) {
            val next = iter.next().toIntArray()

            for (i in 0 until next.size) {
                next[i] +=
                        when {
                            i < 1 -> level[i]
                            i == level.size -> level[i-1]
                            else -> Math.min(level[i - 1], level[i])
                        }
            }

            level = next
        }

        return level.min()!!
    }
}

fun main(args: Array<String>) {
    println(Solution120().minimumTotal(listOf(
            listOf(2),
            listOf(3,4),
            listOf(5,6,7),
            listOf(4,1,8,3)
    )))
}