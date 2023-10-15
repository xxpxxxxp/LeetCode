package com.ypwang.medium

import java.util.*

class Solution2904 {
    fun shortestBeautifulSubstring(s: String, k: Int): String {
        val queue: Queue<Int> = LinkedList()
        var minLen = Int.MAX_VALUE
        var minStr = ""
        for ((i, c) in s.withIndex()) {
            if (c == '1') {
                queue.add(i)
                if (queue.size == k) {
                    val start = queue.poll()
                    val len = i - start + 1
                    val str = s.substring(start, i + 1)
                    if (len < minLen || len == minLen && str < minStr) {
                        minLen = len
                        minStr = str
                    }
                }
            }
        }
        return minStr
    }
}