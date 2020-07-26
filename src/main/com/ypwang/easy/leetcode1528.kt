package com.ypwang.easy

class Solution1528 {
    fun restoreString(s: String, indices: IntArray): String {
        val c = s.toCharArray()

        for (i in c.indices) {
            var cur = i
            var next = indices[cur]
            var char = c[cur]

            while (cur != next) {
                val t = c[next]
                c[next] = char

                cur = next
                next = indices[cur]
                char = t

                indices[cur] = cur
            }
        }

        return c.joinToString("")
    }
}