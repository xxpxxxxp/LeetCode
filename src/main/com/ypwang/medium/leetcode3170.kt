package com.ypwang.medium

import java.util.*

class Solution3170 {
    fun clearStars(s: String): String {
        val s = s.toCharArray()
        val pq = PriorityQueue<Char>()
        val indices = Array(26) { mutableListOf<Int>() }
        for ((i, c) in s.withIndex()) {
            if (c == '*') {
                val ch = pq.peek()
                s[indices[ch - 'a'].last()] = '!'
                indices[ch - 'a'].removeAt(indices[ch - 'a'].size - 1)
                if (indices[ch - 'a'].isEmpty())
                    pq.poll()
                continue
            }
            if (indices[c - 'a'].isEmpty())
                pq.offer(c)
            indices[c - 'a'].add(i)
        }

        val res = StringBuilder()
        for (c in s)
            if (c >= 'a')
                res.append(c)
        return res.toString()
    }
}

fun main() {
    println(Solution3170().clearStars("ee**"))
}