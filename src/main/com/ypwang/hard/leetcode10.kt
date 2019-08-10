package com.ypwang.hard

import java.util.*

class Solution10 {
    interface TryMatch {
        fun match(s: String, si: Int): List<Int>
    }

    class CharMatch(val c: Char): TryMatch {
        override fun match(s: String, si: Int): List<Int> {
            if (si >= s.length || s[si] != c) return listOf()
            return listOf(si+1)
        }
    }

    class MultiCharMatch(val c: Char): TryMatch {
        override fun match(s: String, si: Int): List<Int> {
            val rst = mutableListOf(si)
            var i = 0
            while (true) {
                if (si+i >= s.length || s[si+i] != c) break
                rst.add(si+i+1)
                i++
            }
            return rst
        }
    }

    class DotMatch: TryMatch {
        override fun match(s: String, si: Int): List<Int> {
            if (si >= s.length) return listOf()
            return listOf(si+1)
        }
    }

    class MultiDotMatch: TryMatch {
        override fun match(s: String, si: Int): List<Int> {
            return (si..s.length).toList()
        }
    }

    fun isMatch(s: String, p: String): Boolean {
        if (p.isEmpty()) return s.isEmpty()

        val pattern = mutableListOf<TryMatch>()
        var i = 0
        while (i < p.length) {
            when (p[i]) {
                in 'a'..'z' -> pattern.add(if (i+1 < p.length && p[i+1] == '*') {
                    MultiCharMatch(p[i++])
                } else CharMatch(p[i]))
                '.' -> pattern.add(if (i+1 < p.length && p[i+1] == '*') {
                    MultiDotMatch()
                } else DotMatch())
            }
            i++
        }

        val pts = pattern.toTypedArray()
        // s index, pattern index
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.offer(0 to 0)

        while (queue.isNotEmpty()) {
            val (si, pti) = queue.poll()
            val rts = pts[pti].match(s, si)
            if (pti != pts.lastIndex) {
                rts.forEach { queue.offer(it to pti+1) }
            } else {
                if (rts.any { it == s.length })
                    return true
            }
        }

        return false
    }
}

fun main() {
    println(Solution10().isMatch("a", ""))
    println(Solution10().isMatch("a", "aa"))
    println(Solution10().isMatch("aa", "a"))
    println(Solution10().isMatch("aa", "a*"))
    println(Solution10().isMatch("ab", ".*"))
    println(Solution10().isMatch("aab", "c*a*b"))
    println(Solution10().isMatch("mississippi", "mis*is.*p*."))
}