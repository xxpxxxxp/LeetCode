package com.ypwang.medium

class Robot(private val width: Int, private val height: Int) {
    private val directions = arrayOf(
        "East" to intArrayOf(1, 0),
        "North" to intArrayOf(0, 1),
        "West" to intArrayOf(-1, 0),
        "South" to intArrayOf(0, -1)
    )

    private var x = 0
    private var y = 0
    private var dir = 0
    private var count = 0

    private fun moving() {
        val round = 2 * (width + height) - 4
        var m = count % round
        while (m > 0) {
            val (mx, my) = directions[dir].second
            val (l, z, n) =
                if (mx != 0)
                    Triple(mx, x, width)
                else
                    Triple(my, y, height)

            val mv =
                if (l < 0)
                    z
                else
                    n-1-z

            if (m > mv)
                dir = (dir + 1) % 4

            val actualMove = minOf(mv, m)
            m -= actualMove
            x += actualMove * mx
            y += actualMove * my
        }

        count = 0
    }

    fun move(num: Int) {
        count += num
    }

    fun getPos(): IntArray {
        moving()
        return intArrayOf(x, y)
    }

    fun getDir(): String {
        moving()
        return directions[dir].first
    }
}
