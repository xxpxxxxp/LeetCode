package com.ypwang.hard

import java.util.Stack

class Solution3816 {
    fun lexSmallestAfterDeletion(s: String): String {
        val rem = IntArray(26)
        for (c in s)
            rem[c - 'a']++

        val cnt = IntArray(26)
        val sb = Stack<Char>()

        for (c in s) {
            rem[c - 'a']--
            while (sb.isNotEmpty()) {
                val t = sb.peek()
                if (t > c && (rem[t - 'a'] > 0 || cnt[t - 'a'] > 1)) {
                    cnt[t - 'a']--
                    sb.pop()
                } else
                    break
            }
            sb.add(c)
            cnt[c - 'a']++
        }

        while (sb.isNotEmpty()) {
            val c = sb.last()
            if (cnt[c - 'a'] > 1) {
                cnt[c - 'a']--
                sb.pop()
            } else
                break
        }

        return sb.joinToString("")
    }
}
