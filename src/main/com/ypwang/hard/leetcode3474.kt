package com.ypwang.hard

class Solution3474 {
    fun generateString(str1: String, str2: String): String {
        val n = str1.length
        val m = str2.length
        val L = n + m - 1

        if (n == 0)
            return "a".repeat(L)

        val word = arrayOfNulls<Char>(L)
        val forced = BooleanArray(L)

        for (i in 0 until n) {
            if (str1[i] == 'T') {
                for (j in 0 until m) {
                    val pos = i + j
                    if (word[pos] != null && word[pos] != str2[j])
                        return ""
                    word[pos] = str2[j]
                    forced[pos] = true
                }
            }
        }

        val free = BooleanArray(L)
        for (i in 0 until L) {
            if (word[i] == null) {
                word[i] = 'a'
                free[i] = true
            }
        }

        for (i in 0 until n) {
            if (str1[i] == 'F') {
                if (word.slice(i until (i+m)).joinToString("") == str2) {
                    var fixed = false
                    for (j in m - 1 downTo 0) {
                        val pos = i + j
                        if (free[pos]) {
                            word[pos] = 'b'
                            free[pos] = false
                            fixed = true
                            break
                        }
                    }
                    if (!fixed) {
                        return ""
                    }
                }
            }
        }

        return word.joinToString("")
    }
}
