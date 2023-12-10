package com.ypwang.hard

class Solution2959 {
    fun numberOfSets(n: Int, maxDistance: Int, roads: Array<IntArray>): Int {
        var ans = 0
        for (i in 0 until (1 shl n)) {
            val g = Array(n) { IntArray(n) { 1000000000 } }

            for ((x, y, w) in roads) {
                if (i shr x and 1 == 1 && i shr y and 1 == 1) {
                    g[x][y] = minOf(g[x][y], w)
                    g[y][x] = minOf(g[y][x], w)
                }
            }
            for (j in 0 until n)
                g[j][j] = 0

            for (p in 0 until n)
                for (q in 0 until n)
                    for (k in 0 until n)
                        g[q][k] = minOf(g[q][k], g[q][p] + g[p][k])

            var ok = true
            l@ for (j in 0 until n)
                for (k in 0 until n)
                    if (i shr j and 1 == 1 && i shr k and 1 == 1)
                        if (g[j][k] > maxDistance) {
                            ok = false
                            break@l
                        }

            if (ok)
                ans++
        }
        return ans
    }
}
