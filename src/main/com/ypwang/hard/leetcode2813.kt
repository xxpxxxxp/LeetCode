package com.ypwang.hard

class Solution2813 {
    fun findMaximumElegance(items: Array<IntArray>, k: Int): Long {
        items.sortByDescending { it[0] }
        var rst = 0L
        var cur = 0L
        val dup = mutableListOf<Int>()
        val seen = mutableSetOf<Int>()
        for ((i, arr) in items.withIndex()) {
            val (p, c) = arr
            if (i < k) {
                if (c in seen)
                    dup.add(p)
                cur += p
            } else if (c !in seen) {
                if (dup.isEmpty())
                    break
                cur += p - dup.removeAt(dup.size - 1)
            }
            seen.add(c)
            rst = maxOf(rst, (cur + 1L * seen.size * seen.size))
        }
        return rst
    }
}