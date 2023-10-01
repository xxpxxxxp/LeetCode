package com.ypwang.hard

import java.util.*

class Solution2876 {
    fun countVisitedNodes(edges: List<Int>): IntArray {
        val rst = IntArray(edges.size)
        for (i in edges.indices) {
            var j = i
            val seen = mutableSetOf<Int>()
            val s = Stack<Int>()
            while (j !in seen && rst[j] == 0) {
                seen.add(j)
                s.push(j)
                j = edges[j]
            }
            if (j in seen) {
                val k = s.size - s.indexOf(j)
                j = 0
                while (j < k) {
                    rst[s.pop()] = k
                    ++j
                }
            }
            while (s.isNotEmpty()) {
                j = s.pop()
                rst[j] = rst[edges[j]] + 1
            }
        }
        return rst
    }
}