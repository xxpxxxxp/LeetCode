package com.ypwang.medium

import java.util.LinkedList

class Solution3528 {
    fun baseUnitConversions(conversions: Array<IntArray>): IntArray {
        val n = conversions.size + 1
        val g = Array(n) { mutableListOf<Pair<Int, Int>>() }

        for (v in conversions)
            g[v[0]].add(Pair(v[1], v[2]))

        val ans = IntArray(n) { 0 }
        val mod = 1000000007
        val q = LinkedList<Int>()

        ans[0] = 1
        q.add(0)

        while (q.isNotEmpty()) {
            val x = q.removeFirst()
            for ((y, z) in g[x]) {
                ans[y] = (1L * ans[x] * z % mod).toInt()
                q.add(y)
            }
        }

        return ans
    }
}
