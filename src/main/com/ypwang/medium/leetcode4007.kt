package com.ypwang.medium

class Solution4007 {
    fun maximumWidth(planks: IntArray): Int {
        val count = mutableMapOf<Int, Int>()
        val res = mutableMapOf<Int, Int>()

        for (x in planks) {
            count[x] = count.getOrDefault(x, 0) + 1
            res[x] = res.getOrDefault(x, 0) + 1
        }

        for (a in count.keys) {
            for (b in count.keys) {
                if (a < b)
                    res[a + b] = res.getOrDefault(a + b, 0) + minOf(count[a]!!, count[b]!!)
                if (a == b)
                    res[a + b] = res.getOrDefault(a + b, 0) + count[a]!! / 2
            }
        }

        return res.values.max()
    }
}
