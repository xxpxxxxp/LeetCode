package com.ypwang.easy

class Solution3248 {
    fun finalPositionOfSnake(n: Int, commands: List<String>): Int {
        var x = 0
        var y = 0

        for (c in commands) {
            when (c) {
                "UP" ->
                    x--

                "RIGHT" ->
                    y++

                "DOWN" ->
                    x++

                "LEFT" ->
                    y--
            }
        }

        return x * n + y
    }
}
