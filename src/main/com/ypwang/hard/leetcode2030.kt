package com.ypwang.hard

import java.util.*

class Solution2030 {
    fun smallestSubsequence(s: String, k: Int, letter: Char, repetition: Int): String {
        var r = repetition
        var cnt = s.count { it == letter }
        val stack = Stack<Char>()

        for ((i, c) in s.withIndex()) {
            while (!stack.isEmpty() && stack.peek() > c && s.length - i + stack.size > k && (stack.peek() != letter || cnt > r)) {
                if (stack.pop() == letter) r++
            }
            if (stack.size < k) {
                if (c == letter) {
                    stack.push(c)
                    r--
                } else if (k - stack.size > r) {
                    stack.push(c)
                }
            }
            if (c == letter) cnt--
        }

        return stack.joinToString("")
    }
}