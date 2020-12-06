package com.ypwang.easy

class Solution1678 {
    fun interpret(command: String): String {
        val sb = StringBuilder()

        var idx = 0
        while (idx < command.length) {
            when (command[idx++]) {
                'G' -> sb.append('G')
                '(' -> {
                    if (command[idx] == ')') {
                        sb.append('o')
                        idx++
                    } else {
                        sb.append("al")
                        idx += 3
                    }
                }
            }
        }

        return sb.toString()
    }
}