package com.ypwang.medium

class Solution973 {
    fun kClosest(points: Array<IntArray>, K: Int): Array<IntArray> {
        val m = points.map { Pair(Math.sqrt((it[0]*it[0] + it[1]*it[1]).toDouble()), it) }.toTypedArray()

        // [start, end)
        fun helper(start: Int, end: Int, num: Int) {
            if (num == 0 || end - start == num) {
                return
            }

            val separator = m[start].first
            var i = start + 1
            var j = end - 1
            while (true) {
                while (i < m.size && m[i].first <= separator) {
                    i++
                }
                while (j >= 0 && m[j].first > separator) {
                    j--
                }

                if (i >= j)
                    break

                val t = m[i]
                m[i] = m[j]
                m[j] = t
            }

            val t = m[start]
            m[start] = m[j]
            m[j] = t

            if (i - start > num) {
                helper(start, i, num)
            } else {
                helper(i, end, num - (i - start))
            }
        }

        helper(0, m.size, K)
        return m.take(K).map { it.second }.toTypedArray()
    }
}

fun main() {
    println(Solution973().kClosest(arrayOf(
            intArrayOf(3,3), intArrayOf(5,-1), intArrayOf(-2,4)
    ), 2).map { it.toList() })
}