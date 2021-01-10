package com.ypwang.medium

class Solution1718 {
    private fun backTracking(cur: IntArray, idx: Int, candidates: List<IntArray>): Boolean {
        var idx = idx
        while (idx < cur.size && cur[idx] > 0)
            idx++

        if (idx == cur.size)
            return true

        for (c in candidates.filter { it[1] == 0 }) {
            if (c[0] > 1 && (idx + c[0] >= cur.size || cur[idx + c[0]] > 0))
                continue

            c[1] = 1
            cur[idx] = c[0]
            if (c[0] > 1)
                cur[idx + c[0]] = c[0]

            if (backTracking(cur, idx, candidates))
                return true

            c[1] = 0
            cur[idx] = 0
            if (c[0] > 1)
                cur[idx + c[0]] = 0
        }

        return false
    }

    fun constructDistancedSequence(n: Int): IntArray {
        val arr = IntArray(2 * n - 1)
        backTracking(arr, 0, (n downTo 1).map { intArrayOf(it, 0) })
        return arr
    }
}

fun main() {
    println(Solution1718().constructDistancedSequence(3).toList())
    println(Solution1718().constructDistancedSequence(5).toList())
}