package com.ypwang.medium

class Solution554 {
    fun leastBricks(wall: List<List<Int>>): Int {
        val rst = mutableMapOf<Int, Int>()

        for (line in wall) {
            var cur = 0
            for (brick in line.dropLast(1)) {
                cur += brick
                rst[cur] = rst.getOrDefault(cur, 0) + 1
            }
        }

        return if (rst.isEmpty()) wall.size else wall.size - rst.maxBy { it.value }!!.value
    }
}

fun main(args: Array<String>) {
    println(Solution554().leastBricks(
            listOf(
                    listOf(1,2,2,1),
                    listOf(3,1,2),
                    listOf(1,3,2),
                    listOf(2,4),
                    listOf(3,1,2),
                    listOf(1,3,1,1)
            )
    ))
}