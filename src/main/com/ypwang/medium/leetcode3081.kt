package com.ypwang.medium

import java.util.PriorityQueue

class Solution3081 {
    fun minimizeStringValue(s: String): String {
        val counts = IntArray(27)

        for (c in s) {
            if (c == '?')
                counts[26]++
            else
                counts[c-'a']++
        }

        val heap = PriorityQueue(compareBy<Pair<Char, Int>> { it.second }.thenBy { it.first })
        heap.addAll((0 until 26).map { 'a' + it to counts[it] })

        val replaces = CharArray(counts[26])
        for (z in 0 until counts[26]) {
            val (c, i) = heap.poll()
            replaces[z] = c
            heap.offer(c to i+1)
        }

        replaces.sort()
        val rst = CharArray(s.length)
        var i = 0
        for ((j, c) in s.withIndex()) {
            if (c == '?')
                rst[j] = replaces[i++]
            else
                rst[j] = c
        }

        return String(rst)
    }
}
