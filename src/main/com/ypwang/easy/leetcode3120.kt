package com.ypwang.easy

class Solution3120 {
    fun numberOfSpecialChars(word: String): Int {
        val a = IntArray(26)
        var rst = 0
        for (c in word) {
            if (c.isUpperCase()) {
                when (a[c - 'A']) {
                    0 -> a[c - 'A'] = 1
                    1, 3 -> {}
                    2 -> {
                        rst++
                        a[c - 'A'] = 3
                    }
                }
            }
            else {
                when (a[c - 'a']) {
                    0 -> a[c - 'a'] = 2
                    2, 3 -> {}
                    1 -> {
                        rst++
                        a[c - 'a'] = 3
                    }
                }
            }
        }

        return rst
    }
}
