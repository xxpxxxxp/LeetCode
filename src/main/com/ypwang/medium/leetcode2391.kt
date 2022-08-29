package com.ypwang.medium

class Solution2391 {
    fun garbageCollection(garbage: Array<String>, travel: IntArray): Int {
        val last = mutableMapOf<Char, Int>()
        var res = 0
        for ((i, s) in garbage.withIndex()) {
            res += s.length
            for (c in s)
                last[c] = i
        }

        for (j in 1 until travel.size)
            travel[j] += travel[j - 1]

        for (c in "PGM")
            if (c in last && last[c]!! > 0)
                res += travel[last[c]!! - 1]

        return res
    }
}