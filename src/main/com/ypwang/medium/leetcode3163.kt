package com.ypwang.medium

class Solution3163 {
    fun compressedString(word: String): String {
        var c = word[0]
        var cnt = 0

        val rst = mutableListOf<Char>()
        for (w in word) {
            if (c != w) {
                while (cnt > 9) {
                    rst.add('9')
                    rst.add(c)
                    cnt -= 9
                }

                rst.add('0' + cnt)
                rst.add(c)

                c = w
                cnt = 1
            } else
                cnt++
        }

        while (cnt > 9) {
            rst.add('9')
            rst.add(c)
            cnt -= 9
        }

        rst.add('0' + cnt)
        rst.add(c)

        return rst.joinToString("")
    }
}
