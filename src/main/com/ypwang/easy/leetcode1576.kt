package com.ypwang.easy

class Solution1576 {
    fun modifyString(s: String): String {
        val sb = CharArray(s.length)

        for ((i, c) in s.withIndex()) {
            sb[i] =
                    when (c) {
                        '?' -> {
                            val used = mutableSetOf<Char>()
                            if (i > 0)
                                used.add(sb[i-1])

                            if (i < s.lastIndex)
                                used.add(s[i+1])

                            var r = 'a'
                            for (j in 'a'..'z') {
                                if (j !in used) {
                                    r = j
                                    break
                                }
                            }

                            r
                        }
                        else -> c
                    }
        }

        return sb.joinToString("")
    }
}