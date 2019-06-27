package com.ypwang.hard

import java.util.*

class Solution316 {
    fun removeDuplicateLetters(s: String): String {
        val counts = IntArray(26){0}

        for (c in s) {
            counts[c - 'a']++
        }

        val stack = Stack<Char>()
        val seen = mutableSetOf<Char>()

        for (c in s) {
            counts[c - 'a']--

            if (c !in seen) {
                while (stack.isNotEmpty() && stack.peek() > c && counts[stack.peek() - 'a'] > 0) {
                    seen.remove(stack.pop())
                }
                stack.add(c)
                seen.add(c)
            }
        }

        return stack.joinToString("")
    }
}

fun main() {
    println(Solution316().removeDuplicateLetters("abacb"))
    println(Solution316().removeDuplicateLetters("bcabc"))
    println(Solution316().removeDuplicateLetters("cbacdcbc"))
}