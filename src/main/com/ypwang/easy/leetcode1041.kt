package com.ypwang.easy

class Solution1041 {
    fun isRobotBounded(instructions: String): Boolean {
        var x = 0
        var y = 0

        // 0: North; 1: West; 2: South; 3: East
        var direction = 0
        for (i in 0 until 4) {
            for (ins in instructions) {
                when (ins) {
                    'G' ->
                        when (direction) {
                            0 -> y++
                            1 -> x--
                            2 -> y--
                            3 -> x++
                        }
                    'L' -> direction = (direction + 1) % 4
                    'R' -> direction = (direction + 3) % 4
                }
            }

            if (x == 0 && y == 0)
                return true
        }

        return false
    }
}

fun main() {
    println(Solution1041().isRobotBounded("RRGRRGLLLRLGGLGLLGRLRLGLRLRRGLGGLLRRRLRLRLLGRGLGRRRGRLG"))
}