package com.ypwang.medium

class Solution3905 {
    fun colorGrid(n: Int, m: Int, sources: Array<IntArray>): Array<IntArray> {
        val q = mutableListOf<IntArray>()
        for (s in sources)
            q.add(intArrayOf(s[0], s[1], s[2]))

        q.sortWith(Comparator { a, b -> b[2].compareTo(a[2]) })
        val rst = Array(n) { IntArray(m) }
        for (s in q)
            rst[s[0]][s[1]] = s[2]

        val dx = intArrayOf(1, -1, 0, 0)
        val dy = intArrayOf(0, 0, 1, -1)
        while (q.isNotEmpty()) {
            val (i, j, v) = q.removeFirst()
            for (d in 0..3) {
                val x = i + dx[d]
                val y = j + dy[d]
                if (x in 0 until n && y in 0 until m && rst[x][y] == 0) {
                    rst[x][y] = v
                    q.add(intArrayOf(x, y, v))
                }
            }
        }
        return rst
    }
}
