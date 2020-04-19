package com.ypwang.medium

import java.util.*

class Solution1409 {
    fun processQueries(queries: IntArray, m: Int): IntArray {
        val p = LinkedList<Int>()
        for (i in 1..m) p.add(i)
        val res = IntArray(queries.size)
        for (i in queries.indices) {
            val idx = p.indexOf(queries[i])
            val `val` = p[idx]
            p.removeAt(idx)
            p.addFirst(`val`)
            res[i] = idx
        }
        return res
    }
}