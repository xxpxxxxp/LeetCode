package com.ypwang.hard

class Solution1240 {
    val set = mutableMapOf<Long, Int>()
    var res = Integer.MAX_VALUE

    fun tilingRectangle(n: Int, m: Int): Int {
        if (n == m) return 1
        dfs(minOf(n, m), maxOf(n, m), IntArray(n), 0)
        return res
    }

    private fun dfs(n: Int, m: Int, h: IntArray, cnt: Int) {
        if (cnt >= res) return

        var isFull = true
        var pos = -1
        var minH = Integer.MAX_VALUE

        for (i in 0 until n) {
            if (h[i] < m) isFull = false
            if (h[i] < minH) {
                pos = i
                minH = h[i]
            }
        }
        if (isFull) {
            res = cnt
            return
        }

        var key = 0L
        var base = m + 1L
        for (i in 0 until n) {
            key += h[i] * base
            base *= (m + 1L)
        }
        if (key in set && set[key]!! <= cnt) return
        set[key] = cnt

        var end = pos
        while (end+1 < n && h[end+1] == h[pos] && end+1-pos+minH < m) end++
        for (j in end downTo pos) {
            val curH = j - pos + 1

            val next = h.clone()
            for (k in pos..j) {
                next[k] += curH
            }
            dfs(n, m, next, cnt + 1)
        }
    }
}