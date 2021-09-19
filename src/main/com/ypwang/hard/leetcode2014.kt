package com.ypwang.hard

import java.util.*

class Solution2014 {
    fun longestSubsequenceRepeatedK(s: String, k: Int): String {
        var res = ""
        // q only stores valid subsequences, initialized with a empty string.
        val q: Queue<String> = LinkedList()
        q.offer("")
        while (!q.isEmpty()) {
            var size = q.size
            // BFS layer by layer, within each layer, the cur string has same length
            while (size-- > 0) {
                val cur = q.poll()
                for (i in 'a'..'z') {
                    val next = cur + i
                    if (isSub(s, next, k)) {
                        // always update res since we are looking for lexicographically largest.
                        res = next
                        q.offer(next)
                    }
                }
            }
        }
        return res
    }

    // check if sub * k is a subsequence of string s.
    // Time complexity - O(n)
    private fun isSub(s: String, sub: String, k: Int): Boolean {
        var j = 0
        var repeat = 0
        for (c in s) {
            if (c == sub[j]) {
                j++
                if (j == sub.length) {
                    repeat++
                    if (repeat == k)
                        return true
                    j = 0
                }
            }
        }
        return false
    }
}

fun main() {
    println(Solution2014().longestSubsequenceRepeatedK("letsleetcode", 2))
    println(Solution2014().longestSubsequenceRepeatedK("bb", 2))
    println(Solution2014().longestSubsequenceRepeatedK("ab", 2))
    println(Solution2014().longestSubsequenceRepeatedK("bbabbabbbbabaababab", 3))
}