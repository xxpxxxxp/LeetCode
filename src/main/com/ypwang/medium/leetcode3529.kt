package com.ypwang.medium

class Solution3529 {
    private fun zFunction(s: String): List<Int> {
        val n = s.length
        val z = MutableList(n) { 0 }
        var l = 0
        var r = 0
        for (i in 1 until n) {
            if (i < r) {
                z[i] = minOf(r - i, z[i - l])
            }
            while (i + z[i] < n && s[z[i]] == s[i + z[i]]) {
                z[i]++
            }
            if (i + z[i] > r) {
                l = i
                r = i + z[i]
            }
        }
        return z
    }

    fun countCells(grid: Array<CharArray>, pattern: String): Int {
        val n = grid.size
        val m = grid[0].size
        val pn = pattern.length

        val hBuilder = StringBuilder()
        val vBuilder = StringBuilder()

        hBuilder.append(pattern).append('#')
        vBuilder.append(pattern).append('#')

        for (i in 0 until n)
            for (j in 0 until m)
                hBuilder.append(grid[i][j])

        for (j in 0 until m)
            for (i in 0 until n)
                vBuilder.append(grid[i][j])

        val h = hBuilder.toString()
        val v = vBuilder.toString()

        val zh = zFunction(h)
        val zv = zFunction(v)

        val ok = Array(n) { IntArray(m) }

        var last = 0
        for (i in pn + 1 until h.length) {
            if (last < i - 1)
                last = i - 1
            if (zh[i] == pn) {
                while (last < i + pn - 1) {
                    last++
                    val cIdx = last - (pn + 1)
                    ok[cIdx / m][cIdx % m] = ok[cIdx / m][cIdx % m] or 0b01
                }
            }
        }

        last = 0
        for (i in pn + 1 until v.length) {
            if (last < i - 1)
                last = i - 1
            if (zv[i] == pn) {
                while (last < i + pn - 1) {
                    last++
                    val cIdx = last - (pn + 1)
                    ok[cIdx % n][cIdx / n] = ok[cIdx % n][cIdx / n] or 0b10
                }
            }
        }

        var ans = 0
        for (i in 0 until n)
            ans += ok[i].count { it == 0b11 }
        return ans
    }
}
