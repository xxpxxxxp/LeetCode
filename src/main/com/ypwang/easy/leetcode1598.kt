package com.ypwang.easy

class Solution1598 {
    fun minOperations(logs: Array<String>): Int {
        var stack = 0

        for (log in logs) {
            when (log.substring(0, log.lastIndex)) {
                "." -> {}   // nothing happen
                ".." -> stack = maxOf(0, stack-1)
                else -> stack++
            }
        }

        return stack
    }
}