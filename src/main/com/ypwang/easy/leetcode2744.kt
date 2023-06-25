package com.ypwang.easy

class Solution2744 {
    fun maximumNumberOfStringPairs(words: Array<String>): Int {
        val reversed = words.map { it.reversed() }.groupBy { it }.mapValues { it.value.size }.toMutableMap()

        var cnt = 0

        for (w in words) {
            if (reversed.getOrDefault(w, 0) > 0) {
                if (w == w.reversed())
                    cnt += reversed[w]!! / 2 * 2
                else {
                    cnt++
                    reversed[w] = reversed[w]!! - 1
                }
            }
        }

        return cnt / 2
    }
}