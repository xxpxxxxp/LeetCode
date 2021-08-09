package com.ypwang.easy

import java.lang.StringBuilder

class Solution1957 {
    fun makeFancyString(s: String): String {
        val rst = StringBuilder()
        var count = 0
        var cur = '.'

        for (c in s) {
            if (cur != c) {
                rst.append(cur)
                if (count >= 2)
                    rst.append(cur)

                count = 0
            }

            cur = c
            count++
        }

        rst.append(cur)
        if (count >= 2)
            rst.append(cur)

        return rst.toString().substring(1)
    }
}