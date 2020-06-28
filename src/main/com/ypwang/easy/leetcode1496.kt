package com.ypwang.easy

class Solution1496 {
    fun isPathCrossing(path: String): Boolean {
        val visited = mutableListOf(0)
        var x = 0
        var y = 0

        for (c in path) {
            when (c) {
                'N' -> y++
                'S' -> y--
                'E' -> x++
                'W' -> x--
            }

            val pos = (x shl 16) + y
            if (pos in visited) return true
            visited.add(pos)
        }

        return false
    }
}