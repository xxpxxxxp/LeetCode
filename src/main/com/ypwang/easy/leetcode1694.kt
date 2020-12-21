package com.ypwang.easy

class Solution1694 {
    fun reformatNumber(number: String): String {
        val cs = number.filter { it.isDigit() }
        var idx = 0

        val sb = StringBuilder()
        while (cs.length - idx > 4) {
            sb.append(cs.substring(idx, idx+3))
            idx += 3
            sb.append("-")
        }

        if (cs.length - idx == 3)
            sb.append(cs.substring(idx))
        else {
            sb.append(cs.substring(idx, idx+2))
            if (idx + 2 != cs.length) {
                sb.append("-")
                sb.append(cs.substring(idx+2))
            }
        }
        return sb.toString()
    }
}