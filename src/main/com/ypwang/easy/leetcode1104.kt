package com.ypwang.easy

class Solution1104 {
    fun pathInZigZagTree(label: Int): List<Int> {
        var direction = true        // left to right

        var level = 1
        var sum = 0
        var total = label
        while (total > level) {
            total -= level
            sum += level
            level *= 2
            direction = !direction
        }

        var pos = if (direction) total - 1 else level - total
        val rst = mutableListOf<Int>()
        while (level != 0) {
            rst.add(0, if (direction) sum + pos + 1 else sum + level - pos)
            level /= 2
            sum -= level
            pos /= 2
            direction = !direction
        }

        return rst
    }
}

fun main() {
    println(Solution1104().pathInZigZagTree(26))
}