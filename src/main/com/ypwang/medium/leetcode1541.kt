package com.ypwang.medium

class Solution1541 {
    fun minInsertions(s: String): Int {
        var stack = 0
        var count = 0

        var idx = 0
        while (idx < s.length) {
            val c = s[idx]
            if (c == '(')
                stack++
            else {
                if (idx + 1 == s.length || s[idx + 1] == '(') {
                    // need 2 )
                    count++
                } else idx++

                if (stack > 0)
                    stack--
                else count++
            }

            idx++
        }

        return count + 2 * stack
    }
}

fun main() {
    println(Solution1541().minInsertions("(()))"))
    println(Solution1541().minInsertions("())"))
    println(Solution1541().minInsertions("))())("))
    println(Solution1541().minInsertions("(((((("))
    println(Solution1541().minInsertions(")))))))"))
}