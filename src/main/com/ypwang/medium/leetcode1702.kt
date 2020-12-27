package com.ypwang.medium

class Solution1702 {
    fun maximumBinaryString(binary: String): String {
        val c0 = binary.count { it == '0' }
        if (c0 < 2)
            return binary

        val sb = StringBuilder()
        for (c in binary) {
            if (c == '1')
                sb.append('1')
            else {
                repeat(c0-1) {
                    sb.append('1')
                }
                sb.append('0')
                repeat(binary.length - sb.length) {
                    sb.append('1')
                }

                return sb.toString()
            }
        }

        return sb.toString()
    }
}