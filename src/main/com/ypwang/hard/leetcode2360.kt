package com.ypwang.hard

class Solution2360 {
    fun longestCycle(edges: IntArray): Int {
        var rst = -1
        val m = Array(edges.size) { -1 to -1 }
        for (i in edges.indices) {
            var j = i
            var dist = 0
            while (j != -1) {
                val (di, fi) = m[j]
                if (di == -1)
                    m[j] = (dist++) to i
                else {
                    if (fi == i)
                        rst = maxOf(rst, dist - di)
                    break
                }
                j = edges[j]
            }
        }

        return rst
    }
}