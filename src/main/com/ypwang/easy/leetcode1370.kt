package com.ypwang.easy

import java.lang.StringBuilder

class Solution1370 {
    fun sortString(s: String): String {
        val count = IntArray(26)
        s.forEach { count[it - 'a']++ }
        val sb = StringBuilder()
        var exist = true
        var direction = true

        while (exist) {
            exist = false
            val range = if (direction) 0..25 else 25 downTo 0
            for (i in range) {
                if (count[i] > 0) {
                    exist = true
                    sb.append('a' + i)
                    count[i]--
                }
            }
            direction = !direction
        }

        return sb.toString()
    }
}