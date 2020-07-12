package com.ypwang.hard

class Solution1515 {
    fun getMinDistSum(positions: Array<IntArray>): Double {
        fun dis(x: Double, y: Double): Double =
                positions.map { (xx, yy) -> Math.sqrt((x-xx)*(x-xx) + (y-yy)*(y-yy)) }.sum()

        var x = positions.map { it[0] }.average()
        var y = positions.map { it[1] }.average()

        var ans = dis(x, y)
        var chg = 100.0
        while (chg > 1e-6) {
            var zoom = true
            for ((dx, dy) in listOf(-1 to 0, 0 to -1, 0 to 1, 1 to 0)) {
                val xx = x + chg * dx
                val yy = y + chg * dy
                val d = dis(xx, yy)
                if (d < ans) {
                    ans = d
                    zoom = false
                    x = xx
                    y = yy
                }

            }

            if (zoom) chg /= 2
        }

        return ans
    }
}