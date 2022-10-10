package com.ypwang.medium

import java.util.*

class Solution2434 {
    fun robotWithString(s: String): String {
        val cnt = IntArray(26)
        s.forEach { cnt[it - 'a']++ }

        var smallest = 0
        val sb = StringBuilder()
        val stack = Stack<Char>()
        for (c in s) {
            stack.push(c)
            val i = c - 'a'
            --cnt[i]
            while (smallest < 26 && cnt[smallest] == 0)
                smallest++
            while (stack.isNotEmpty() && stack.peek() - 'a' <= smallest)
                sb.append(stack.pop())
        }

        return sb.toString()
    }
}